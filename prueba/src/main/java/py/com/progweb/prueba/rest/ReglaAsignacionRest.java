package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.ReglaAsignacionDAO;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("regla_asignacion")
@Consumes("application/json")
@Produces("application/json")
public class ReglaAsignacionRest {

    @Inject
    private ReglaAsignacionDAO reglaAsigacionDAO;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(reglaAsigacionDAO.lista()).build();
    }

}
