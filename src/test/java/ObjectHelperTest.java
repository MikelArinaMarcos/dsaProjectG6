import  dsa.proyecto.g6.Models.*;
import dsa.proyecto.g6.Util.ObjectHelper;
import org.junit.Assert;
import org.junit.Test;

public class ObjectHelperTest {

    @Test
    public void test(){
        Usuario u = new Usuario(1,"Batman","super@mail.com","Bin","Superman","cum");
        Assert.assertEquals("Batman", ObjectHelper.getter(u, "username"));
        ObjectHelper.setter(u,"username","Calico");
        Assert.assertEquals("Calico",u.getUsername());
    }
}
