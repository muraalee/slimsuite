package com.innovationem.controller;

import org.slim3.util.StringUtil;

import static com.innovationem.util.StringConstants.*;

public class AsyncController extends BaseController {

	public boolean isSafeRequest() {
		String retryCountStr = request.getHeader("X-AppEngine-TaskRetryCount");
		int retryCount = StringUtil.isEmpty(retryCountStr) ? 0 : Integer
				.parseInt(retryCountStr);
		String key = asString(SECRET_KEY);
		return SECRET_KEY_VALUE.equals(key) && retryCount < 2;
	}

}