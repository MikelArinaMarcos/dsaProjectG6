import dsa.proyecto.g6.JuegoManager;
import dsa.proyecto.g6.JuegoManagerImpl;

import dsa.proyecto.g6.Models.VOUsuario;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class JuegoManagerImplTest {


    final static Logger logger = Logger.getLogger(JuegoManagerImpl.class);
    JuegoManager jm;

    public void setUp() {
        jm = new JuegoManagerImpl();

        jm.añadirUsuario(new VOUsuario("PabloKsado","Pablo@PartidoPopular.es","Pablo", "Ksado", "SoyKsadoEnjoyer"));
        jm.añadirUsuario(new VOUsuario("Marshall","Marshall@gmail.com", "Marcel", "Marco","Estoesunacontraseña"));
        jm.añadirUsuario(new VOUsuario("MarioRelajao","MarioRelajadisimo@gmail.com",  "Mario", "Cerdà", "SoyLoLPlayerComoSupiste"));

    }

    @After
    public void tearDown() {
        this.jm = null;
        logger.info("--- End of the test ---");
    }

    @Test
    public void AñadirUsuario() {
        logger.info("--- Start of the test - Add User ---");

        logger.info("Condicions inicials: ");
        Assert.assertEquals(3,this.jm.sizeUsers());

        logger.info("S'afegeix 1 usuari: Paula");
        this.jm.añadirUsuario(new VOUsuario("MikelElJefe","Mikel@ElJefe.com","Mikel", "ElJefe", "SoyElJefe"));

        Assert.assertEquals(4,this.jm.sizeUsers());

    }


}
