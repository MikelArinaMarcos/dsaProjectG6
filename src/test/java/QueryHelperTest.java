import  dsa.proyecto.g6.Models.*;
import dsa.proyecto.g6.Util.*;
import org.junit.Assert;
import org.junit.Test;

public class QueryHelperTest {
    @Test
    public void testQueryINSERT() {
        Assert.assertEquals("INSERT INTO Usuario (idUsuario, xp, username, mail, name, lastName, password, dinero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                QueryHelper.createQueryINSERT(new Usuario(1,0,"Batman","super@mail.com","Bin","Superman","cum",1010)));
    }

    @Test
    public void testQuerySELECT(){
        Assert.assertEquals("SELECT * FROM Usuario WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Usuario(1,0,"Batman","super@mail.com","Bin","Superman","cum",1010)));
    }

    @Test
    public void testQuerySELECTALL(){
        Usuario u = new Usuario(1,0,"Batman","super@mail.com","Bin","Superman","cum",1010);
        Class clase = u.getClass();
        Assert.assertEquals("SELECT * FROM Usuario",
                QueryHelper.createQuerySELECTAll(clase));
    }
}
