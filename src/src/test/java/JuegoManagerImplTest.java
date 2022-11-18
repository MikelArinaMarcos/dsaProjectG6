import dsa.proyecto.g6.JuegoManager;
import dsa.proyecto.g6.JuegoManagerImpl;
import dsa.proyecto.g6.Models.VOUsuario;
import dsa.proyecto.g6.Models.VOCredenciales;
import dsa.proyecto.g6.Models.Usuario;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class JuegoManagerImplTest {


    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);
    JuegoManager jm;

    @Before
    public void setUp() {
        jm = new JuegoManagerImpl();

        jm.añadirUsuario(new VOUsuario("PabloKsado","Pablo@PartidoPopular.es","Pablo", "Ksado", "SoyKsadoEnjoyer"));
        jm.añadirUsuario(new VOUsuario("Marshall","Marshall@gmail.com", "Marcel", "Marco","Estoesunacontraseña"));
        jm.añadirUsuario(new VOUsuario("MarioRelajao","MarioRelajadisimo@gmail.com",  "Mario", "Cerdà", "SoyLoLPlayerComoSupiste"));

    }

    @After
    public void tearDown() {
        this.jm = null;
        logger.info("--- Fin del test ---");
    }

    @Test
    public void RegistroUsuario() {
        logger.info("--- Inicio Test- Añadir Usuario ---");

        logger.info("Usuarios iniciales: ");
        Assert.assertEquals(3,this.jm.sizeUsers());

        logger.info("Añadimos 1 usuario: MikelElJefe");
        this.jm.añadirUsuario(new VOUsuario("MikelElJefe","Mikel@ElJefe.com","Mikel", "ElJefe", "SoyElJefe"));

        Assert.assertEquals(4,this.jm.sizeUsers());

    }

    @Test
    public void logIn(){
        logger.info("--- Inicio Test - LogIn ---");
        List<Usuario> users = this.jm.getAllUsers();
        VOCredenciales cred1 = this.jm.getCredentials(users.get(0));
        logger.info("Probando LogIn "+cred1);

        Assert.assertEquals(users.get(0), this.jm.loginUsuario(cred1));

        VOCredenciales cred2 = this.jm.getCredentials(users.get(0));
        cred2.setPassword("random");
        logger.info("Probando LogIn "+cred2);

        Assert.assertEquals(null, this.jm.loginUsuario(cred2));
    }




}
