package com.springboot.webapp.login;

public class AuthenticateService {
    public boolean authenticate(String username, String password) {
        boolean isValidUserName = username.equalsIgnoreCase("mojojojo");
        boolean isValidPassword = password.equalsIgnoreCase("mojojojo");
        return isValidUserName && isValidPassword;
    }
}
