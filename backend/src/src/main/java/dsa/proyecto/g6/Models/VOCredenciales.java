package dsa.proyecto.g6.Models;

public class VOCredenciales {

String Mail, Password;

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
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
