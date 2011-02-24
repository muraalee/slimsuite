package com.innovationem.controller;

import com.google.gdata.util.common.base.StringUtil;

import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;

import static com.innovationem.service.ServiceFactory.*;
import static com.innovationem.util.StringConstants.*;

public class UploadController extends BaseController {
	private static Navigation nav = new Navigation("/jsp/layouts/layout.jsp",
			false);

	public Navigation index() throws Exception {
		requestScope(EMAIL, googleAuthEmail());
		return nav;
	}

	public Navigation applet() throws Exception {
		processUpload();
		return SUCCESS_NAVIGATION;
	}

	public Navigation flash() throws Exception {
		return forward("/jsp/upload/flash.jsp");
	}

	private void processUpload() throws Exception {
		FileItem formFile = requestScope("file");
		if (formFile == null)
			formFile = requestScope("imagedata");
		String fileName = (String) request.getAttribute("fileName");
		if (StringUtil.isEmpty(fileName))
			fileName = formFile.getFileName();
		//
		// your business logic
		//
	}

	public Navigation simple() throws Exception {
		processUpload();
		// your business logic
		response.sendRedirect(FIRST_LANDING_PAGE);
		return null;
	}
}
