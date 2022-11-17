package dsa.proyecto.g6;

import dsa.proyecto.g6.Models.Usuario;

import java.util.HashMap;
import java.util.Map;
//import java.util.logging.Logger;
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
    public Usuario loginUsuario(String Username, String password) {
        return null;
    }
}
