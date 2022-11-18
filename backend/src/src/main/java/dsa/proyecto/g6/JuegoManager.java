package dsa.proyecto.g6;

import dsa.proyecto.g6.Models.Usuario;
import dsa.proyecto.g6.Models.VOCredenciales;
import dsa.proyecto.g6.Models.VOUsuario;

public interface JuegoManager {

    public int size();

    public void registrarUsuario(String Username, String password, String name, String lastname, String mail);

    public Usuario loginUsuario(VOCredenciales credenciales);

    public VOCredenciales getCredentials(Usuario u);

    public String getUserByMail(String mail); //

    public String getUser(VOCredenciales credencials); //

    Usuario añadirUsuario(VOUsuario VOusuario);

    public int sizeUsers();
}
