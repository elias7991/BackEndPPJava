package py.com.progweb.prueba.rest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import py.com.progweb.prueba.ejb.BolsaPuntosDAO;


@Path("clienteporvencer")
@Consumes("application/json")
@Produces("application/json")

// servicio que trae los clientes con puntos proximos a expirar
public class ClientesPorVencerRest {

    @Inject
    private BolsaPuntosDAO bolsapuntosDAO;

    @GET
    @Path("/{dias}")
    public Response listarPorVencer(@PathParam("dias") Integer dias){
        return Response.ok(bolsapuntosDAO.listaPorVencer(dias)).build();
    }


}
