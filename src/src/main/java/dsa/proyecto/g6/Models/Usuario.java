package dsa.proyecto.g6.Models;

public class Usuario {

    private String  username;
    private String mail;
    private String name;
    private String lastname;
    private String password;


public Usuario (){}
    public Usuario (String username, String mail, String name, String lastname, String pasword ){
         this.username = username;
         this.mail = mail;
         this.name = name;
         this.lastname = lastname;
         this.password = pasword;
    }

    public Usuario(VOUsuario VOusuario) {
         this();
         this.setUsername(VOusuario.getUsername());
         this.setMail(VOusuario.getMail());
         this.setName(VOusuario.getName());
         this.setLastname(VOusuario.getName());
         this.setPassword(VOusuario.getPassword());
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
