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
    //Cosntructor de un usuario nuevo, no necesitamos XP, ID y el dinero se lo metemos por code
    public Usuario (String Username,String Mail, String Name, String LastName, String Pasword){
         this.username = Username;
         this.xp = 0;
         this.mail = Mail;
         this.name = Name;
         this.lastName = LastName;
         this.password = Pasword;
         this.dinero = 100;
         //this.objetosUsuario = new ArrayList<>();
    }
    //Constructor para un usuario que ya existe y recuperamos de la BBD, por lo que necesitamos todos sus campos
    public Usuario(int idUsuario, int xp, String username, String mail, String name, String lastName, String password, Integer dinero) {
        this.idUsuario = idUsuario;
        this.xp = xp;
        this.username = username;
        this.mail = mail;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.dinero = dinero;
    }

    public Usuario(VOUsuario VOusuario) {
         this();
         this.idUsuario = 0;
         this.xp = 0;
         this.setUsername(VOusuario.getUsername());
         this.setMail(VOusuario.getMail());
         this.setName(VOusuario.getName());
         this.setLastName(VOusuario.getName());
         this.setPassword(VOusuario.getPassword());
         this.setDinero(100);
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
