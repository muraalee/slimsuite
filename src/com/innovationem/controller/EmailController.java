package com.innovationem.controller;

import org.slim3.controller.Navigation;

import static com.innovationem.service.ServiceFactory.*;

public class EmailController extends BaseAuthController {

    public Navigation index() throws Exception {
        String toEmail = asString("email");
        String toName = asString("name");
        String subject = asString("subject");
        String body = asString("body");
        emailService.sendEmail(toEmail, toName, subject, body);
        return SUCCESS_NAVIGATION;
    }

}
