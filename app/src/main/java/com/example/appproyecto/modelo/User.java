package com.example.appproyecto.modelo;

public class User {
    private String mail;
    private String password;
    private String name;
    private String username;
    private String lastName;

    public User(){}

    public User(String mail, String password, String name, String username, String lastName) {
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.username = username;
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getLastName() {
        return lastName;
    }
}
