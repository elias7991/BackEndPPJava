package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.UsoPuntosDAO;
import py.com.progweb.prueba.model.UsoPuntos;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("uso_puntos")
@Consumes("application/json")
@Produces("application/json")
public class UsoPuntosRest {

    @Inject
    private UsoPuntosDAO usoPuntosDAO;

    @POST
    @Path("/")
    public Response usarPuntos(UsoPuntos u) {
        this.usoPuntosDAO.agregar(u);
        return Response.ok().build();
    }

}
