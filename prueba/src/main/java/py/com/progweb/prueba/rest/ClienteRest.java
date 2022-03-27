package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.ClienteDAO;
import py.com.progweb.prueba.model.Cliente;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

@Path("cliente")
@Consumes("application/json")
@Produces("application/json")
public class ClienteRest {

    @Inject
    private ClienteDAO personaDAO;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(personaDAO.lista()).build();
    }

    @POST
    @Path("/")
    public Response crear(Cliente p) {
    	this.personaDAO.agregar(p);
	return Response.ok().build();
    }


}
