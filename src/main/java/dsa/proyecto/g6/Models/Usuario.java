package dsa.proyecto.g6.Models;


import dsa.proyecto.g6.Exceptions.PocoDineroException;

import java.util.List;

public class Usuario {

    private String username;
    private String mail;
    private String name;
    private String lastName;
    private String password;

    private Integer dinero;

    private List<Tienda> objetosUsuario;



    public Usuario (){}
    public Usuario (String Username,String Mail, String Name, String LastName, String Pasword, Integer Dinero ){
         this.username = Username;
         this.mail = Mail;
         this.name = Name;
         this.lastName = LastName;
         this.password = Pasword;
         this.dinero = Dinero;
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

    public Integer getDinero() {
        return dinero;
    }

    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

    public List<Tienda> getObjetosUsuario() {
        return objetosUsuario;
    }

    public void setObjetosUsuario(List<Tienda> objetosUsuario) {
        this.objetosUsuario = objetosUsuario;
    }


    public void compraObjeto(Tienda objeto) throws PocoDineroException {
        if (objeto.getPrecio() > this.dinero){
            throw new PocoDineroException();
        }

        this.dinero = this.dinero - objeto.getPrecio();
        objetosUsuario.add(objeto);

    }


}
