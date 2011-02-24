package com.innovationem.controller;

import com.innovationem.model.User;

import org.slim3.controller.Navigation;

import javax.servlet.RequestDispatcher;
import java.util.logging.Logger;

import static com.innovationem.service.ServiceFactory.*;
import static com.innovationem.util.StringConstants.*;

/**
 * User: Murali Varadarajan Date: Sep 25, 2010
 */
public class BaseAuthController extends BaseController {
	protected Long userID;
	protected User user;

	private static final Logger logger = Logger
			.getLogger(BaseAuthController.class.getName());
	static Navigation navigation = new Navigation("/jsp/layouts/layout.jsp",
			false);

	@Override
	public Navigation run() throws Exception {
		String googleAuthEmail = googleAuthEmail();
		String sessionEmail = sessionScope(EMAIL);
		if (googleAuthEmail != null && googleAuthEmail.equals(sessionEmail)) {
			// No questions asked move on.
			User user = userService.getUserByEmail(googleAuthEmail);
			requestScope(USER, user);
			requestScope(USER_ID, user.getKey().getId());
			return proceedFurther();
		} else {
			if (googleAuthEmail == null) { // User not authenticated
				logger.info("User not authenticated hence sending him for google authentication");
				String loginURL = googleUserService
						.createLoginURL(FIRST_LANDING_PAGE);
				response.sendRedirect(loginURL);
			} else { // User Authenticated but Session not established
				User user = userService.getUserByEmail(googleAuthEmail);
				if (user == null) {
					// User authenticated but trying to access random url, so prompt him for
					// registration screen
					logger.info(googleAuthEmail
							+ " User authenticated and first time registration");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/registration/index");
					dispatcher.forward(request, response);
				} else {
					logger.info("User authenticated and session established in BaseController ");
					sessionScope(EMAIL, user.getEmail());
					// Fundamental connection between established sessions & un-established ones
					sessionScope(THEME, user.getTheme());
					requestScope(USER,
							userService.getUserByEmail(user.getEmail()));
					requestScope(USER_ID, user.getKey().getId());
					return proceedFurther();
				}
			}
		}
		return null;
	}

	public void preProcess() {
		userID = requestScope(USER_ID);
		user = requestScope(USER);
	}
}
