package dsa.proyecto.g6.Models;


import dsa.proyecto.g6.Exceptions.PocoDineroException;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private int idUsuario;

    private int xp;
    private String username;
    private String mail;
    private String name;
    private String lastName;
    private String password;

    private Integer dinero;
    //Ahora tiene mas sentido usar una tabla relacional en la  BBDD
    //private ArrayList<Objeto> objetosUsuario;



    public Usuario (){}



    public Usuario (String Username, String Mail, String Name, String LastName, String Pasword){
         this.idUsuario = 0;
         this.xp = 0;
         this.username = Username;
         this.mail = Mail;
         this.name = Name;
         this.lastName = LastName;
         this.password = Pasword;
         this.dinero = 10;

    }

    public Usuario(VOUsuario VOusuario) {
         this();
         this.setUsername(VOusuario.getUsername());
         this.setMail(VOusuario.getMail());
         this.setName(VOusuario.getName());
         this.setLastName(VOusuario.getName());
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void comprarObjeto(Objeto objeto) {

        this.dinero = this.dinero - objeto.getPrecio();
        //mmm aqui se tendir auqe relacionar con las BBDD
    }

    public String getObject() {
        return null;
        //Aqui habria que retornar los objetos que tiene el usuario en la BBDD
    }

    /*public List<Objeto> getObjetosUsuario() {
        return objetosUsuario;
    }

    public void setObjetosUsuario(ArrayList<Objeto> objetosUsuario) {
        this.objetosUsuario = objetosUsuario;
    }*/


    /*public void compraObjeto(Tienda objeto) throws PocoDineroException {
        if (objeto.getPrecio() > this.dinero){
            throw new PocoDineroException();
        }

        this.dinero = this.dinero - objeto.getPrecio();
        objetosUsuario.add(objeto);

    }*/ //Porro tienda objetos


}
