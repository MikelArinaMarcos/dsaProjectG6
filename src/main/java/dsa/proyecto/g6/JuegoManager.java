package dsa.proyecto.g6;

import dsa.proyecto.g6.Exceptions.PocoDineroException;
import dsa.proyecto.g6.Exceptions.YaTienesObjetoException;
import dsa.proyecto.g6.Models.*;

import java.util.List;

public interface JuegoManager {

    public int size();


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

    public Usuario registroJugador(Usuario usuario);

    public Usuario loginJugador(VOCredenciales credenciales);

    /*public void comprarObjeto (String Username, String nombreObjeto) throws PocoDineroException, YaTienesObjetoException;
     */}
