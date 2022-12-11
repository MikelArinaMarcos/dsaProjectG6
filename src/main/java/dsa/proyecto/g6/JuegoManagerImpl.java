package dsa.proyecto.g6;

import dsa.proyecto.g6.BBDD.FactorySession;
import dsa.proyecto.g6.BBDD.Session;
import dsa.proyecto.g6.Models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;

import static java.util.stream.Collectors.toList;

public class JuegoManagerImpl implements JuegoManager{

    private static JuegoManager instance;
    protected Map<String, Usuario> usuarios;
    protected List<Objeto> objetos;

    final static Logger logger = Logger.getLogger(JuegoManager.class);



    public JuegoManagerImpl(){

        this.usuarios = new HashMap<>();
        this.objetos = new ArrayList<>();
    }

    public static JuegoManager getInstance(){
        if (instance == null) instance = new JuegoManagerImpl();
        return instance;
    }
    @Override
    public int size() {
        int ret = this.usuarios.size();
        logger.info("size " + ret);

        return ret;
    }

    @Override
    public void registrarUsuario(String Username, String password, String name, String lastname, String mail, Integer dinero) {

        Usuario usuario = new Usuario(Username, password, name, lastname, mail, dinero);
        this.usuarios.put(usuario.getUsername(), usuario);
        logger.info("Usuarui registrado correctamente!!");
    }

    @Override
    public Usuario loginUsuario(VOCredenciales credenciales) {
        logger.info("Login: " + credenciales.getMail());

        String u = getUser(credenciales);
        if (u == null){
            logger.warn("Login no aceptado");

            return null;
        }
        logger.info("Login aceptado");
        return usuarios.get(u);

    }

    public VOCredenciales getCredentials(Usuario a) {
        return new VOCredenciales(a);
    }
    public String getUser(VOCredenciales credencials) {

        logger.info("Trying to get User "+ credencials.getMail());

        String iduser = getUserByMail(credencials.getMail());
        if(iduser!=null)
            if (this.usuarios.get(iduser).getPassword().equals(credencials.getPassword())){
                logger.info("User Found: "+this.usuarios.get(iduser));
                return iduser;
            }

        logger.warn("User Not Found "+credencials.getMail());
        return null;
    }

    @Override
    public Usuario añadirUsuario(VOUsuario VOusuario) {

        logger.info("Trying to create new User: " + VOusuario.getUsername());

        if (getUserByMail(VOusuario.getMail()) == null) {
            Usuario u = new Usuario(VOusuario);
            this.usuarios.put(VOusuario.getUsername(), u);
            logger.info("New User added ID = "+VOusuario.getUsername());

            return u;
        }
        logger.warn("Could not add new User bc it already exists user with that mail");

        return null;

    }

    @Override
    public Objeto añadirObjeto(Objeto VOObjeto) {
        logger.info("Trying to create new Object " + VOObjeto.getNombre());

        this.objetos.add(VOObjeto);
        logger.info("New Object added = "+VOObjeto);

        return VOObjeto;
    }

    @Override
    public List<Objeto> getAllObjects() {
        List<Objeto> list = this.objetos;
        return list;
    }


    @Override
    public int sizeUsers() {
        int ret = this.usuarios.size();
        logger.info("There are " + ret+" users");

        return ret;
    }

    @Override
    public int sizeObjects() {
        logger.info("El tamaño de la lista de objetos es :" + objetos.size());
        return this.objetos.size();
    }

    @Override
    public List<Usuario> getAllUsers() {
        List<Usuario> list = this.usuarios.values().stream().collect(toList());

        return list;
    }

    @Override
    public Usuario deleteUser(VOUsuario VOusuario) {
        logger.info("Trying to remove new User: " + VOusuario.getUsername());

        if (getUserByMail(VOusuario.getMail()) != null) {
            usuarios.remove(getUserByMail(VOusuario.getMail()));
            logger.warn("User removed. Te arrepentiras de dejar este juego");
            return null;
        }
        logger.warn("Could not remove user");

        return null;
    }

    @Override
    public Usuario getUserByKey(String key) {
        logger.info("Trying to get User with key "+ key);
        if(usuarios.containsKey(key)){
            Usuario u = usuarios.get(key);
            return u;
        }
        return null;
    }



    public String getUserByMail(String mail) {
        logger.info("Trying to get User with mail "+mail);

        for (Map.Entry<String, Usuario> entry : this.usuarios.entrySet()) {
            if (entry.getValue().getMail().equals(mail)){
                logger.info("User Found: "+entry.getValue().getName());

                return entry.getKey();
            }
        }
        logger.warn("Not found any user with "+mail);

        return null;
    }

    @Override
    public Usuario registroJugador(Usuario usuario) {
        Session session = null;
        try{
            session = FactorySession.openSession();
            session.save(usuario);
            return usuario;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public Usuario loginJugador(VOCredenciales credenciales) {/*
        Session session = null;
        try{
            session = FactorySession.openSession();
            session.get(credenciales,0);
            return credenciales;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        */
        return null;
    }
}
