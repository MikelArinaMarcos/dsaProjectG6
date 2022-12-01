package com.example.appproyecto.modelo;

public class UserLogin {
    private String mail;
    private String password;

    public UserLogin(){}

    public UserLogin(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
