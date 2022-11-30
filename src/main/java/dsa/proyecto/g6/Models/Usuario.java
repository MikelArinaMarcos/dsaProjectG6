package dsa.proyecto.g6.Models;


import dsa.proyecto.g6.Exceptions.PocoDineroException;

import java.util.List;

public class Usuario {

    private String Username;
    private String Mail;
    private String Name;
    private String LastName;
    private String Password;

    private Integer Dinero;

    private List<Tienda> objetosUsuario;



    public Usuario (){}
    public Usuario (String Username,String Mail, String Name, String LastName, String Pasword, Integer Dinero ){
         this.Username = Username;
         this.Mail = Mail;
         this.Name = Name;
         this.LastName = LastName;
         this.Password = Pasword;
         this.Dinero = Dinero;
    }

    public Usuario(VOUsuario VOusuario) {
         this();
         this.setUsername(VOusuario.getUsername());
         this.setMail(VOusuario.getMail());
         this.setName(VOusuario.getName());
         this.setLastName(VOusuario.getName());
         this.setPassword(VOusuario.getPassword());
         this.setDinero(1000000);
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getDinero() {
        return Dinero;
    }

    public void setDinero(Integer dinero) {
        Dinero = dinero;
    }

    public List<Tienda> getObjetosUsuario() {
        return objetosUsuario;
    }

    public void setObjetosUsuario(List<Tienda> objetosUsuario) {
        this.objetosUsuario = objetosUsuario;
    }


    public void compraObjeto(Tienda objeto) throws PocoDineroException {
        if (objeto.getPrecio() > this.Dinero){
            throw new PocoDineroException();
        }

        this.Dinero = this.Dinero - objeto.getPrecio();
        objetosUsuario.add(objeto);

    }


}
