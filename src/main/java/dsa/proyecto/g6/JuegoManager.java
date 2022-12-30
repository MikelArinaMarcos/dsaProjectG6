package dsa.proyecto.g6;

import dsa.proyecto.g6.Exceptions.PocoDineroException;
import dsa.proyecto.g6.Exceptions.YaTienesObjetoException;
import dsa.proyecto.g6.Models.*;
//import jdk.jpackage.internal.PackagerException;

import java.util.List;

public interface JuegoManager {

    public int size();

   // public void registrarUsuario(String Username, String password, String name, String lastname, String mail, Integer dinero);

    public Usuario loginUsuario(VOCredenciales credenciales);

    public VOCredenciales getCredentials(Usuario u);

    public String getUserByMail(String mail); //

    public String getUser(VOCredenciales credencials); //

    Usuario añadirUsuario(VOUsuario VOusuario);

    public int sizeUsers();

    public int sizeObjects();

    List<Usuario> getAllUsers();

    public Usuario deleteUser(VOUsuario VOusuario);

    public Usuario getUserByKey(String key);

    public Objeto añadirObjeto(Objeto VOObjeto);

    List<Objeto> getAllObjects();

    public VOUsuario registroJugador(VOUsuario usuario);

    public Usuario loginJugador(VOCredenciales credenciales);

    public void comprarObjeto (String Username, String nombreObjeto) throws PocoDineroException, YaTienesObjetoException;
}
