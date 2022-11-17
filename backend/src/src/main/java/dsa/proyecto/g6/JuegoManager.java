package dsa.proyecto.g6;

import dsa.proyecto.g6.Models.Usuario;

public interface JuegoManager {

    public int size();

    public void registrarUsuario(String Username, String password, String name, String lastname, String mail);

    public Usuario loginUsuario(String Username, String password);

}
