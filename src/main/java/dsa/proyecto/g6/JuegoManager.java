package dsa.proyecto.g6;

import dsa.proyecto.g6.Models.*;

import java.util.List;

public interface JuegoManager {

    public int size();

    public void registrarUsuario(int idUsuario, int xp, String Username, String password, String name, String lastname, String mail, Integer dinero);

    public Usuario loginUsuario(VOCredenciales credenciales);

    public VOCredenciales getCredentials(Usuario u);

    public String getUserByMail(String mail); //

    public String getUser(VOCredenciales credencials); //

    Usuario añadirUsuario(VOUsuario VOusuario);

    public int sizeUsers();

    public int sizeObjects();

    List<Usuario> getAllUsers();

    public int deleteUser(Usuario user);

    public Usuario getUserByKey(String key);

    public Objeto añadirObjeto(Objeto VOObjeto);

    List<Objeto> getAllObjects();

    public Usuario registroJugador(Usuario usuario);

    Objeto insertarObjeto(Objeto objeto);

    Objeto getObjeto(int idObjeto);

    public Usuario loginJugador(VOCredenciales credenciales);

    public Usuario updateUsuario(Usuario user, int id);

    public relacionOU comprarObjeto (int idUsuario, int idObjeto);

    public Usuario getUsuario(int idUsuario);

    public Objeto updateObjeto(Objeto objeto, int id);

    Issue Issue(Issue issue);

    public List<FAQ> getPreguntas();

    public int sizePreguntas();

    public FAQ añadirFAQ(FAQ faq);

    Enemigo getEnemy(int idEnemy);

    List<Enemigo> getAllEnemys();

    Usuario registroJugador2(Usuario usuario);

    Issue anañirIssue(Issue issue);

    List<Issue> getAllIssues();
}
