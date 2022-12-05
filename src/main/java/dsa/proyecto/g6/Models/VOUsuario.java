package dsa.proyecto.g6.Models;



public class VOUsuario {
    private String Username, Mail, Name, LastName, Password;
    private Integer Dinero;

    public VOUsuario(){};



    public VOUsuario(String Username, String Mail, String Name, String LastName, String Password, Integer Dinero){
        this.Username = Username;
        this.Mail = Mail;
        this.Name = Name;
        this.LastName = LastName;
        this.Password = Password;
        this.Dinero = Dinero;
}

    public VOUsuario(Usuario u) {
        this();
        this.setName(u.getName());
        this.setUsername(u.getUsername());
        this.setMail(u.getMail());
        this.setLastName(u.getLastName());
        this.setPassword(u.getPassword());
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
}
