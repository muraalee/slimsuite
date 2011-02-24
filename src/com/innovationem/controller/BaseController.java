package com.innovationem.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.AppEngineUtil;
import org.slim3.util.StringUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.innovationem.util.StringConstants.*;

/**
 * User: Murali Varadarajan Date: Sep 25, 2010
 */

public class BaseController extends Controller {
	static Navigation navigation = new Navigation(
			"/jsp/layouts/public-layout.jsp", false);
	static Navigation SUCCESS_NAVIGATION = new Navigation("/jsp/success.jsp",
			false);
	static Navigation FAILURE_NAVIGATION = new Navigation("/jsp/failure.jsp",
			false);
	static Navigation ERROR_NAVIGATION = new Navigation("/jsp/error.jsp", false);
	static Navigation NOT_AUTH_NAVIGATION = new Navigation(
			"/jsp/not-authorized.jsp", false);

	private static String POST_PAGE_SUFFIX = "-done";

	@Override
	protected Navigation run() throws Exception {
		return proceedFurther();
	}

	public Navigation proceedFurther() throws Exception {
		Navigation navigation;
		try {
			String controller = request.getServletPath();
			controller = StringUtil.isEmpty(controller) ? "" : controller
					.replace("/", "");
			String command = request.getParameter(COMMAND);
			command = StringUtil.isEmpty(command) ? "index" : command;
			String pageSuffix = "GET".equals(request.getMethod()) ? ""
					: POST_PAGE_SUFFIX;
			// Setting the PAGE
			requestScope(PAGE, controller + "/" + command + pageSuffix);
			requestScope(TITLE, DEFAULT_TITLE);
			updateContext(controller, command);
			this.preProcess();
			Method method = this.getClass().getDeclaredMethod(command);
			navigation = (Navigation) method.invoke(this);
			this.postProcess();
		} catch (InvocationTargetException exception) {
			throw exception;
			// requestScope("exception", exception.getTargetException());
			// navigation = ERROR_NAVIGATION;
		}
		return navigation;
	}

	private void updateContext(String controller, String command) {
		requestScope("currentState", controller + "-" + command);
		if ("upload".equals(controller)) {
			requestScope("uploadState", "ui-state-active");
		} else {

		}
	}

	public void setWebsiteInRequest() {
		requestScope("websiteName", getWebsite());
	}

	public String getWebsite() {
		if (AppEngineUtil.isDevelopment()) {
			String serverName = request.getServerName();
			int portNumber = request.getServerPort();
			return ("http://" + serverName + ":" + portNumber);
		} else
			return WEBSITE_NAME;
	}

	public void preProcess() {

	}

	public void postProcess() {

	}
}
