package com.innovationem.controller;

import com.innovationem.model.User;

import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;

import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;

import static com.innovationem.service.ServiceFactory.*;
import static com.innovationem.util.DataUtil.*;
import static com.innovationem.util.StringConstants.*;

public class RegistrationController extends BaseController {
	private static final Logger logger = Logger
			.getLogger(RegistrationController.class.getName());

	public Navigation index() throws Exception {
		if (isPost()) {
			User user = new User();
			BeanUtil.copy(request, user);
			user.setEmail(googleAuthEmail());
			userService.createUser(user);

			emailService.sendEmail(user.getEmail(), user.getFullName(),
					"<img src='" + getWebsite() + "/images/logo.png' />"
							+ " myStoredLife.com registration Successful",
					"<br/>Please login @ " + getWebsite());
			logger.info(user.getEmail()
					+ " User registered, sending him for Picasa Authentication ");
			requestScope("message",
					"User created successfully " + user.getEmail());
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(FIRST_LANDING_PAGE);
			dispatcher.forward(request, response);
			return null;
		} else {
			String googleAuthEmail = googleAuthEmail();
			if (googleAuthEmail == null) {
				logger.info(" Registration Controller - User not authenticated hence sending him for google authentication. ");
				String loginURL = googleUserService
						.createLoginURL(FIRST_LANDING_PAGE);
				response.sendRedirect(loginURL);
				return null;
			} else {
				requestScope("relations", RELATIONS);
				requestScope("countries", COUNTRIES);
				requestScope("email", googleAuthEmail);
			}

		}
		return navigation;

	}

}
