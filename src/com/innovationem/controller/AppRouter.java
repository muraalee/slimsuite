package com.innovationem.controller;

/**
 * User: Murali Varadarajan
 * Date: Sep 25, 2010
 */

import javax.servlet.http.HttpServletRequest;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {

	public AppRouter() {
		addRouting("/_ah/login?{message}", "/_ah/login?{message}");
		addRouting("/_ah/logout?{message}", "/_ah/logout?{message}");
		addRouting("/{app}/{cmd}/{id}", "/{app}?cmd={cmd}&id={id}");
		addRouting("/{app}/{cmd}/{id}?{params}",
				"/{app}?cmd={cmd}&id={id}&{params}");
		addRouting("/{app}/{cmd}", "/{app}?cmd={cmd}");
	}

	public String route(HttpServletRequest request, String path) {
		if (request == null) {
			throw new NullPointerException("The request parameter is null.");
		}
		if (path == null) {
			throw new NullPointerException("The path parameter is null.");
		}
		if (path.startsWith("/_ah/admin") || path.startsWith("/_ah/resources")) {
			return null; // /_ah/admin, /_ah/adminConsole, /_ah/resources - don't route
		}
		return super.route(request, path);
	}
}
