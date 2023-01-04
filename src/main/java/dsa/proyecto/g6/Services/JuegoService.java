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
            Usuario user1 = this.jm.añadirUsuario(new VOUsuario("ErBryan","Bryan@gmail.com","Bryan", "Garcia", "1234"));
            VOCredenciales cred1 = this.jm.getCredentials(user1);
            Usuario user2 = this.jm.añadirUsuario(new VOUsuario("M.Rajoy","M.rajoy@ChipsAjoy.com",  "Mariano", "Rajoy", "aaa"));
            VOCredenciales cred3 = this.jm.getCredentials(user1);
            Usuario u3 = this.jm.añadirUsuario(new VOUsuario("a","a","a", "a", "a")); //User para hacer tests mas rapidos
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
    public Response addUser(VOUsuario voUser) {//Antes VOUsuario user
        Usuario user = new Usuario(voUser);
        user = this.jm.registroJugador(user);
        if (user == null) {
            return Response.status(500).build();
        }
        else
            return Response.status(201).entity(user).build();
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
        if (u==null)
            return Response.status(500).build();
        else
            return Response.status(201).entity(u).build();
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

   /* @DELETE
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
    */

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
    @POST
    @ApiOperation(value = "Add an object", notes = "Añadimos objeto a la tabla de objetos")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Objeto.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/objeto/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarObjeto(Objeto objeto) {
        Objeto u = this.jm.insertarObjeto(objeto);
        if (u==null) {
            return Response.status(500).build();
        }
        else
            return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "get an User", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "Usuario not found")
    })
    @Path("/user/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("idUser") int idUsuario) {
        Usuario u = this.jm.getUsuario(idUsuario);
        if (u == null)
            return Response.status(500).build();
        else
            return Response.status(201).entity(u).build();
    }

    @GET
    @ApiOperation(value = "get an Object", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class),
            @ApiResponse(code = 404, message = "Objeto not found")
    })
    @Path("/objeto/{idObjeto}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjeto(@PathParam("idObjeto") int idObjeto) {
        Objeto i = this.jm.getObjeto(idObjeto);
        if (i == null) return Response.status(404).build();
        else  return Response.status(201).entity(i).build();
    }



    @PUT
    @ApiOperation(value = "update Usuario", notes = "Porfavor no explotes")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Fino mi \uD83E\uDD19pana\uD83E\uDD19"),
            @ApiResponse(code = 404, message = "Usuario not found")
    })
    @Path("/user/update/{idUsuario}")
    public Response updateUser(Usuario usuario, @PathParam("idUsuario") int id) {
        Usuario u = this.jm.updateUsuario(usuario, id);
        if (u == null)
            return Response.status(404).build();
        else
            return Response.status(201).build();
    }


    @POST
    @ApiOperation(value = "Buy an object", notes = "Añadimos objeto a la tabla relacional")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= relacionOU.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/user/buy/{idObjeto}/{idUsuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response comprarObjeto(@PathParam("idUsuario")int idUsuario, @PathParam("idObjeto")int idObjeto) {
        relacionOU rou = this.jm.comprarObjeto(idUsuario, idObjeto);

        if (rou==null) {
            return Response.status(500).build();
        }
        else
            return Response.status(201).build();
    }
    @PUT
    @ApiOperation(value = "update Objeto", notes = "Porfavor no explotes v2")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Fino mi \uD83E\uDD19pana\uD83E\uDD19"),
            @ApiResponse(code = 404, message = "Usuario not found")
    })
    @Path("/objeto/update/{idObjeto}")
    public Response updateObjeto(Objeto objeto, @PathParam("idObjeto") int id) {
        Objeto o = this.jm.updateObjeto(objeto, id);
        if (o == null)
            return Response.status(404).build();
        else
            return Response.status(201).build();
    }
    @PUT
    @ApiOperation(value = "Deletus de un User", notes = "https://cdn.drawception.com/drawings/VjJWWdm1V7.png")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/usuario/delete")
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUsuario(Usuario user) {
        System.out.println("Saludos entro a eliminar Fetus Deletus");
        int res = this.jm.deleteUser(user);
        System.out.println("RES ES "+res);
        if (res==1) {
            return Response.status(201).build();
        }
        else
            return Response.status(500).build();
    }

}
