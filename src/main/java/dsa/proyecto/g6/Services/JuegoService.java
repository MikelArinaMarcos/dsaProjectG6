package dsa.proyecto.g6.Services;


import dsa.proyecto.g6.JuegoManager;
import dsa.proyecto.g6.JuegoManagerImpl;
import dsa.proyecto.g6.Models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Api(value = "/juego")
@Path("/juego")
public class JuegoService {

    private JuegoManager jm;


    public JuegoService() {
        this.jm = JuegoManagerImpl.getInstance();
        if (jm.sizeUsers()==0) {
            Usuario user1 = this.jm.añadirUsuario(new VOUsuario("ErBryan","Bryan@gmail.com","Bryan", "Garcia", "1234", 1000000));
            VOCredenciales cred1 = this.jm.getCredentials(user1);
            Usuario user2 = this.jm.añadirUsuario(new VOUsuario("M.Rajoy","M.rajoy@ChipsAjoy.com",  "Mariano", "Rajoy", "aaa", 1000000));
            VOCredenciales cred3 = this.jm.getCredentials(user1);
            Usuario u3 = this.jm.añadirUsuario(new VOUsuario("a","a","a", "a", "a", 1000000)); //User para hacer tests mas rapidos
        }
        if (jm.sizeObjects()==0){
            this.jm.añadirObjeto(new Objeto(1,"Seiken","Espada legendaria de ESCANOR (un Dios entre humanos)",10000));
            this.jm.añadirObjeto(new Objeto(2,"Excalibur","Las leyendas ni se acercan a su verdadero poder",15000));
            this.jm.añadirObjeto(new Objeto(3,"Muramasa","La katana definitva (el poder corrompe a los mas debiles)",20000));
        }
    }

    @POST
    @ApiOperation(value = "register a user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= VOUsuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/users/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(Usuario user) {/*   //Antes VOUsuario user
        Usuario u = this.jm.añadirUsuario(user);
        if (u==null) return Response.status(500).build();

        VOUsuario vo = new VOUsuario(u);
        return Response.status(201).entity(vo).build();
        */
        Usuario u = this.jm.registroJugador(user);
        if (u==null) {
            return Response.status(500).build();
        }
        else
            return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "login", notes = "Realitzar el login")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logIn(VOCredenciales credencials) {
        System.out.println("-----LOGIN-----");
        System.out.println("Mail: "+ credencials.getMail());
        Usuario u = this.jm.loginUsuario(credencials);
        if (u==null)  return Response.status(500).build();
        else return Response.status(201).entity(u).build();
    }

    @GET
    @ApiOperation(value = "get all Users", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
    })
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<Usuario> listaUsuario = this.jm.getAllUsers();
        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(listaUsuario){};
        //List<Usuario> tracks = this.jm.getAllUsers();
        //GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(tracks) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @DELETE
    @ApiOperation(value = "delete a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{mail}")
    public Response deleteUser(@PathParam("mail") String mail) {
        String key = this.jm.getUserByMail(mail);
        Usuario t = this.jm.getUserByKey(key);
        VOUsuario vou = new VOUsuario(t);
        if (t == null) return Response.status(404).build();
        else this.jm.deleteUser(vou);
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "get all Objects", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
    })
    @Path("/objetos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjects() {
        List<Objeto> listaObjetos = this.jm.getAllObjects();
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(listaObjetos){};
        return Response.status(201).entity(entity).build();

    }

}
