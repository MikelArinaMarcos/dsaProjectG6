package dsa.proyecto.g6.Services;


import dsa.proyecto.g6.JuegoManager;
import dsa.proyecto.g6.JuegoManagerImpl;
import dsa.proyecto.g6.Models.Usuario;
import dsa.proyecto.g6.Models.VOCredenciales;
import dsa.proyecto.g6.Models.VOUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/juego")
@Path("/juego")
public class JuegoService {

    private JuegoManager jm;


    public JuegoService() {
        this.jm = JuegoManagerImpl.getInstance();
        if (jm.sizeUsers()==0) {
            Usuario user1 = this.jm.añadirUsuario(new VOUsuario("ErBryan","Bryan@gmail.com","Bryan", "Garcia", "1234"));
            VOCredenciales cred1 = this.jm.getCredentials(user1);
            Usuario user2 = this.jm.añadirUsuario(new VOUsuario("M.Rajoy","M.rajoy@ChipsAjoy.com",  "Mariano", "Rajoy", "aaa"));
            VOCredenciales cred3 = this.jm.getCredentials(user1);
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
    public Response addUser(VOUsuario user) {
        Usuario u = this.jm.añadirUsuario(user);
        if (u==null) return Response.status(500).build();

        VOUsuario vo = new VOUsuario(u);
        return Response.status(201).entity(vo).build();
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
        Usuario u = this.jm.loginUsuario(credencials);
        if (u==null)  return Response.status(500).build();
        else return Response.status(201).entity(u).build();
    }

    @GET
    @ApiOperation(value = "get all Users", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<Usuario> tracks = this.jm.getAllUsers();

        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(tracks) {};
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

}
