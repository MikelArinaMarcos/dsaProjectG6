package dsa.proyecto.g6;

import dsa.proyecto.g6.Models.Usuario;

import java.util.HashMap;
import java.util.Map;
//import java.util.logging.Logger;
import dsa.proyecto.g6.Models.VOCredenciales;
import dsa.proyecto.g6.Models.VOUsuario;
import org.apache.log4j.Logger;

public class JuegoManagerImpl implements JuegoManager{

    private static JuegoManager instance;
    protected Map<String, Usuario> usuarios;

    final static Logger logger = Logger.getLogger(JuegoManager.class);



    public JuegoManagerImpl(){
        this.usuarios = new HashMap<>();
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
    public void registrarUsuario(String Username, String password, String name, String lastname, String mail) {

        Usuario usuario = new Usuario(Username, password, name, lastname, mail);
        this.usuarios.put(usuario.getUsername(), usuario);
        logger.info("Usuarui registrado correctamente!!");
    }

    @Override
    public Usuario loginUsuario(VOCredenciales credenciales) {
        logger.info("Login: " + credenciales);

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

        logger.info("Trying to get User "+ credencials);

        String iduser = getUserByMail(credencials.getMail());
        if(iduser!=null)
            if (this.usuarios.get(iduser).getPassword().equals(credencials.getPassword())){
                logger.info("User Found: "+this.usuarios.get(iduser));
                return iduser;
            }

        logger.warn("User Not Found "+credencials);
        return null;
    }

    @Override
    public Usuario añadirUsuario(VOUsuario VOusuario) {

        logger.info("Trying to create new User: " + VOusuario);

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
    public int sizeUsers() {
        int ret = this.usuarios.size();
        logger.info("There are " + ret+" users");

        return ret;
    }


    public String getUserByMail(String mail) {
        logger.info("Trying to get User with mail "+mail);

        for (Map.Entry<String, Usuario> entry : this.usuarios.entrySet()) {
            if (entry.getValue().getMail().equals(mail)){
                logger.info("User Found: "+entry.getValue());

                return entry.getKey();
            }
        }
        logger.warn("Not found any user with "+mail);

        return null;
    }
}
