import dsa.proyecto.g6.JuegoManager;
import dsa.proyecto.g6.JuegoManagerImpl;
import dsa.proyecto.g6.Models.*;
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

        jm.añadirObjeto(new Objeto(1,"Seiken","Espada legendaria de ESCANOR (un Dios entre humanos)",10000));
        jm.añadirObjeto(new Objeto(2,"Excalibur","Las leyendas ni se acercan a su verdadero poder",15000));
        jm.añadirObjeto(new Objeto(3,"Muramasa","La katana definitva (el poder corrompe a los mas debiles)",20000));
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

    @Test
    public void Objetos(){
        logger.info("---Prueba con los objetos---");
        List<Objeto> objetos = this.jm.getAllObjects();
        Objeto obj1 = objetos.get(2);
        Assert.assertEquals("Muramasa",obj1.getNombre());
        Assert.assertEquals(3,objetos.size());
    }

}
