import dsa.proyecto.g6.BBDD.FactorySession;
import dsa.proyecto.g6.BBDD.Session;
import dsa.proyecto.g6.Models.Usuario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ORMTest {
    /**Aqui vaciamos la BBDD de posibles pruebas que hayamos hecho antes,
     * revisar cuando se implemente de forma definitiva para no petarnos
     * todos los datos que existan
     * @author relaxedMario
     */
    @Before
    public void setUP() {
        Session s = FactorySession.openSession();
        s.clean();
    }

    @After
    public void tearDown(){}

    @Test
    public void test1(){
        Usuario u = new Usuario(1,0,"Batman","super@mail.com","Bin","Superman","cum",1010);
        Session s = FactorySession.openSession();
        s.save(u);
    }


}
