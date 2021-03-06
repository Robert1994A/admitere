<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-header">
		<a class="navbar-brand" href="#/home"><span
			style="font-size: 30px"><b>ADMITERE UCV</b></span></a>


		<ul class="nav navbar-nav visible-xs-block">
			<li><a data-toggle="collapse" data-target="#navbar-mobile"><i
					class="icon-tree5"></i></a></li>
			<li><a class="sidebar-mobile-main-toggle"><i
					class="icon-paragraph-justify3"></i></a></li>
		</ul>
	</div>

	<div class="navbar-collapse collapse" id="navbar-mobile">
		<ul class="nav navbar-nav">
			<li><a class="sidebar-control sidebar-main-toggle hidden-xs"><i
					class="icon-paragraph-justify3"></i></a></li>
		</ul>

		<p class="navbar-text">
			<span class="label bg-success">Online</span>
		</p>

		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> <i class="icon-bubbles4"></i> <span
					class="visible-xs-inline-block position-right">Messages</span> <span
					class="badge bg-warning-400">1</span>
			</a>

				<div class="dropdown-menu dropdown-content width-350">
					<div class="dropdown-content-heading">
						Messages
						<ul class="icons-list">
							<li><a href="#"><i class="icon-compose"></i></a></li>
						</ul>
					</div>

					<ul class="media-list dropdown-content-body">

						<li class="media">
							<div class="media-left">
								<img src="./resources/assets/images/demo/users/face25.jpg"
									class="img-circle img-sm" alt="">
							</div>
							<div class="media-body">
								<a href="#" class="media-heading"> <span
									class="text-semibold">Richard Vango</span> <span
									class="media-annotation pull-right">Mon</span>
								</a> <span class="text-muted">Other travelling salesmen live
									a life of luxury...</span>
							</div>
						</li>

					</ul>

					<div class="dropdown-content-footer">
						<a href="#" data-popup="tooltip" title="All messages"><i
							class="icon-menu display-block"></i></a>
					</div>
				</div></li>

			<li class="dropdown dropdown-user"><a class="dropdown-toggle"
				data-toggle="dropdown"> <img
					src="./resources/assets/images/demo/users/face11.jpg"> <span>
						<security:authorize access="isAuthenticated()">
							<security:authentication property="principal.username" />
						</security:authorize>
				</span> <i class="caret"></i>
			</a>

				<ul class="dropdown-menu dropdown-menu-right">
					<li><a href="#/profile"><i class="icon-user-plus"></i>My
							profile</a></li>
					<li class="divider"></li>
					<li><a href="./logout"><i class="icon-switch2"></i> Logout</a></li>
				</ul></li>
		</ul>
	</div>
</div>
