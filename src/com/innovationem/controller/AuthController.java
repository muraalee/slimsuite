package com.innovationem.controller;

import com.innovationem.util.StringConstants;

import org.slim3.controller.Navigation;

import static com.innovationem.service.ServiceFactory.*;
import static com.innovationem.util.StringConstants.*;

public class AuthController extends BaseController {

	public Navigation login() throws Exception {
		String loginURL = googleUserService
				.createLoginURL(StringConstants.FIRST_LANDING_PAGE);
		response.sendRedirect(loginURL);
		return null;
	}

	public Navigation logout() throws Exception {
		String logoutURL = googleUserService.createLogoutURL("/public");
		sessionScope(EMAIL, null);
		response.sendRedirect(logoutURL);
		return null;
	}
}
