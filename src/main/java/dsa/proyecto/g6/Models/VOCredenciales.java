package dsa.proyecto.g6.Models;

public class VOCredenciales {

private String mail, password;

public VOCredenciales(){}
public VOCredenciales(String M , String P){
    this();
    this.setMail(M);
    this.setPassword(P);
}

    public VOCredenciales(Usuario a) {
        this();
        this.setPassword(a.getPassword());
        this.setMail(a.getMail());
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
