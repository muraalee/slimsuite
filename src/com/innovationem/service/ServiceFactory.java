package com.innovationem.service;

import com.google.appengine.api.users.UserServiceFactory;

/**
 * Created by IntelliJ IDEA.
 * User: murali
 * Date: Jul 4, 2010
 * Time: 12:20:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceFactory {

    public static EmailService emailService = new EmailService();
    public static UserService userService = new UserService();

    public static com.google.appengine.api.users.UserService googleUserService = UserServiceFactory.getUserService();

    public static String googleAuthEmail() {
        com.google.appengine.api.users.User googleUser = googleUserService.getCurrentUser();
        if (googleUser != null) return googleUser.getEmail().toLowerCase();
        return null;
    }

}
