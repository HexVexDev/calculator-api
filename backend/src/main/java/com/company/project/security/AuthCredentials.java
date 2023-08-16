package com.company.project.security;

public class AuthCredentials {
    private String username;
    private String pass;

    public void setUsername(String email) {
        this.username = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public String getUsername() {
        return username;
    }
}
