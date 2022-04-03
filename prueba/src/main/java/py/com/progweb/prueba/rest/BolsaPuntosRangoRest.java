package py.com.progweb.prueba.rest;
import py.com.progweb.prueba.ejb.BolsaPuntosDAO;
import py.com.progweb.prueba.model.BolsaPuntos;

import javax.ejb.EJBTransactionRolledbackException;
import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.inject.Inject;


@Path("bolsapuntosporcliente")
@Consumes("application/json")
@Produces("application/json")

public class BolsaPuntosRangoRest {
    
    @Inject
    private BolsaPuntosDAO bolsapuntosDAO;

    @GET
    // persona/
    @Path("/{idCliente}")
    public Response listarRango(@PathParam("idCliente") Integer idCliente){
        return Response.ok(bolsapuntosDAO.listaCliente(idCliente)).build();
    }

}
