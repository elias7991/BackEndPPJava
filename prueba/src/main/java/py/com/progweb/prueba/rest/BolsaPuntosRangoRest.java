package py.com.progweb.prueba.rest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import py.com.progweb.prueba.ejb.BolsaPuntosDAO;



@Path("bolsapuntosRango")
@Consumes("application/json")
@Produces("application/json")

public class BolsaPuntosRangoRest {
    
    @Inject
    private BolsaPuntosDAO bolsapuntosDAO;

    @GET
    // rango es una cadena de este tipo: limiteInferior-limiteSuperior
    @Path("/{rango}")
    public Response listarRango(@PathParam("rango") String rango){
        return Response.ok(bolsapuntosDAO.listaRango(rango)).build();
    }

}
