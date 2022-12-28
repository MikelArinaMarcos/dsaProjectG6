import  dsa.proyecto.g6.Models.*;
import dsa.proyecto.g6.Util.*;
import org.junit.Assert;
import org.junit.Test;

public class QueryHelperTest {
    @Test
    public void testQueryINSERT() {
        Assert.assertEquals("INSERT INTO Usuario (ID, username, mail, name, lastName, password, dinero) VALUES (?, ?, ?, ?, ?, ?, ?)",
                QueryHelper.createQueryINSERT(new Usuario("Batman","super@mail.com","Bin","Superman","cum",1010)));
    }

    @Test
    public void testQuerySELECT(){
        Assert.assertEquals("SELECT * FROM Usuario WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Usuario(1,"Batman","super@mail.com","Bin","Superman","cum")));
    }
}
