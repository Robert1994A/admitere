package ro.inf.ucv.admitere.controller.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ro.inf.ucv.admitere.entity.Contract;
import ro.inf.ucv.admitere.entity.Role;
import ro.inf.ucv.admitere.entity.User;
import ro.inf.ucv.admitere.utils.Generator;

/**
 * Handles requests for the application home page.
 */
@Controller
@EnableWebMvc
@PropertySource(value = "classpath:config.properties")
public class HomeController extends BaseController {

	private String googleMapsAPIKey = "AIzaSyAIa0k0JGw-N3SFeVrsP13SLJGb7mgn-Kc";

	public void initDatabaseUsers() {
		Generator myGenerator = new Generator();

		Role roleAdmin = new Role();
		roleAdmin.setName("ADMIN");
		roleService.save(roleAdmin);

		Role roleModerator = new Role();
		roleModerator.setName("MODERATOR");
		roleService.save(roleModerator);

		Role roleUser = new Role();
		roleUser.setName("USER");
		roleService.save(roleUser);

		List<Role> rolesAdmin = new ArrayList<Role>();
		rolesAdmin.add(roleModerator);
		rolesAdmin.add(roleAdmin);
		rolesAdmin.add(roleUser);

		List<Role> rolesModerator = new ArrayList<Role>();
		rolesModerator.add(roleModerator);
		rolesModerator.add(roleUser);

		List<Role> rolesUser = new ArrayList<Role>();
		rolesUser.add(roleUser);

		for (int i = 0; i < 100; i++) {
			User userAdmin = new User();
			userAdmin.setEnabled(true);
			userAdmin.setCreationDate(new Date());
			userAdmin.setExpiredDate(new Date());
			userAdmin.setEmail("admin@gmail.com" + i);
			userAdmin.setRegisterToken(generator.getRandomString());
			userAdmin.setUsername("admin" + i);
			userAdmin.setPassword(encoder.encode("admin" + i));
			userAdmin.setRoles(rolesAdmin);
			userAdmin.setRecoverPaswordToken(encoder.encode(String.valueOf(i)));
			userService.save(userAdmin);
		}

		for (int i = 0; i < 100; i++) {
			User moderator = new User();
			moderator.setEnabled(true);
			moderator.setCreationDate(new Date());
			moderator.setExpiredDate(new Date());
			moderator.setEmail("moderator@gmail.com" + i);
			moderator.setRegisterToken(generator.getRandomString());
			moderator.setUsername(myGenerator.getGeneratedString());
			moderator.setPassword(encoder.encode("moderator" + i));
			moderator.setRoles(rolesModerator);
			moderator.setRecoverPaswordToken(encoder.encode(String.valueOf(i)));
			userService.save(moderator);
		}

		for (int i = 0; i < 100; i++) {
			User user1 = new User();
			user1.setCreationDate(new Date());
			user1.setExpiredDate(new Date());
			user1.setEnabled(true);
			user1.setEmail("user@gmail.com" + i);
			user1.setRegisterToken(generator.getRandomString());
			user1.setUsername("user" + i);
			user1.setPassword(encoder.encode("user" + i));
			user1.setRoles(rolesUser);
			user1.setRecoverPaswordToken(encoder.encode(String.valueOf(i)));
			userService.save(user1);
		}

	}

	public void initDatabaseContract() {
		for (int i = 0; i < 100; i++) {
			Contract contract = new Contract();
			contract.setContent(new StringBuilder("content" + i));
			contract.setDescription("description" + i);
			contract.setName("name" + i);
			contract.setPublished(true);
			contract.setPublishedDate(new Date());
			contractPageService.save(contract);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception {
		if (userService.findAll().isEmpty()) {
			initDatabaseUsers();
		}
		if (contractPageService.findAll().isEmpty()) {
			initDatabaseContract();
		}
		model.addAttribute("googleAPIKey", googleMapsAPIKey);
		return "home";
	}

}
