package ro.inf.ucv.admitere.utils;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class Generator {

	private static final String SALT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

	public String getGeneratedString() {
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) {
			int index = (int) (rnd.nextFloat() * SALT_CHARS.length());
			salt.append(SALT_CHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public String getRandomString() {

		return RandomStringUtils.random(128, true, true);

	}
}
