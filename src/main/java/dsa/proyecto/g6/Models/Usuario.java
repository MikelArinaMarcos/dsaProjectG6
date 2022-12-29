package dsa.proyecto.g6.Models;

import dsa.proyecto.g6.Util.IDs;

//Esta es la clase Usuario general, de esta clase nace VOUsuario para hacer el registro y VOCrendenciales para hacer el login
public class Usuario {

    private String username;
    private String mail;
    private String name;
    private String lastName;
    private String password;

    private Integer idUsuario;

    private Integer xp;




    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    private Integer dinero;
    //Ahora tiene mas sentido usar una tabla relacional en la  BBDD
    //private ArrayList<Objeto> objetosUsuario;



    public Usuario (){}
    public Usuario (String Username,String Mail, String Name, String LastName, String Pasword){
         this.idUsuario = IDs.generarId();
         this.username = Username;
         this.mail = Mail;
         this.name = Name;
         this.lastName = LastName;
         this.password = Pasword;
         this.dinero = 1000000;
         this.xp = 0;
    }

    public Usuario(VOUsuario VOUsuario) {
        String username;
        String mail;
        String name;
        String lastName;
        String password;
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
