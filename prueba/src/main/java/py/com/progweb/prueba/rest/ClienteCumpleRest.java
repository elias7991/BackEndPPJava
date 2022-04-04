package py.com.progweb.prueba.rest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import py.com.progweb.prueba.ejb.ClienteDAO;

@Path("clientecumple")
@Consumes("application/json")
@Produces("application/json")

public class ClienteCumpleRest {

    @Inject
    private ClienteDAO clienteDAO;

    @GET
    @Path("/{mesCumple}")
    public Response listarCumple(@PathParam("mesCumple") String mesCumple){
        return Response.ok(clienteDAO.listaCumple(mesCumple)).build();
    }

}
