package com.codegym.c0319h2.quanlycongty.message.request;

public class LogInForm {

    private String username;

    private String password;

    public LogInForm() {
    }

    public LogInForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
