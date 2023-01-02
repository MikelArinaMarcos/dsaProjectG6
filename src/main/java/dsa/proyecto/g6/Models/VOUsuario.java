package dsa.proyecto.g6.Models;



public class VOUsuario {
    private String username, mail, name, lastName, password;
    //private Integer dinero;

    public VOUsuario(){};

    public VOUsuario(String Username, String Mail, String Name, String LastName, String Password){
        this.username = Username;
        this.mail = Mail;
        this.name = Name;
        this.lastName = LastName;
        this.password = Password;

}

    public VOUsuario(Usuario u) {
        this();
        this.setName(u.getName());
        this.setUsername(u.getUsername());
        this.setMail(u.getMail());
        this.setLastName(u.getLastName());
        this.setPassword(u.getPassword());



    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
/*
    public Integer getDinero() {
        return dinero;
    }

    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }
    */

}
