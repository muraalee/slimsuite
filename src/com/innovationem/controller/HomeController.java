package com.innovationem.controller;

import org.slim3.controller.Navigation;
import org.slim3.util.StringUtil;

import static com.innovationem.service.ServiceFactory.*;
import static com.innovationem.util.StringConstants.*;

public class HomeController extends BaseAuthController {
	static Navigation customNavigation = new Navigation(
			"/jsp/layouts/home-layout.jsp", false);

	public Navigation index() throws Exception {
		requestScope(PAGE, "home/index");
		return customNavigation;
	}

	public Navigation theme() throws Exception {
		String theme = asString(ID);
		if (!StringUtil.isEmpty(theme)) {
			sessionScope("theme", theme);
			user.setTheme(theme);
			userService.updateUser(user);
		}
		return index();
	}

	public Navigation test() throws Exception {
		return navigation;
	}

	public Navigation aboutUs() throws Exception {
		requestScope(PAGE, "public/aboutUs");
		return navigation;
	}

	public Navigation agreement() throws Exception {
		requestScope(PAGE, "public/agreement");
		return navigation;
	}

}
