package py.com.progweb.prueba.ejb;

import org.hibernate.QueryException;
import py.com.progweb.prueba.model.BolsaPuntos;
import py.com.progweb.prueba.model.Cabecera;
import py.com.progweb.prueba.model.ConceptoUsoPuntos;
import py.com.progweb.prueba.model.UsoPuntos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UsoPuntosDAO {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    ConceptoUsoPuntosDAO puntosDAO;
    CabeceraDAO cabeceraDAODAO;

    public void agregar(UsoPuntos entidad) {


        ConceptoUsoPuntos concepto = puntosDAO.searchById(entidad.getIdConcepto());

        // Cantidad de puntos a utilizar
        int puntosRequeridos = concepto.getPuntosRequeridos();
        int puntosUtilizados = 0;

        // Bolsas disponibles para uso
        Query q = this.em.createQuery("select b from BolsaPuntos b where b.id_cliente = ?1 and b.saldo_puntos > ?2 order by b.fecha_asignacion asc" );
        q.setParameter(1, entidad.getIdCliente());
        q.setParameter(2, 0);
        List<BolsaPuntos> bolsas = (List<BolsaPuntos>)q.getResultList();

        // Lista de bolsas uilizadas
        ArrayList<BolsaPuntos> bolsasUtilizadas = new ArrayList<BolsaPuntos>();

        // Buscar todas las bolsas a utilizar para los puntos necesarios
        for(BolsaPuntos b : bolsas){
            bolsasUtilizadas.add(b);
            puntosUtilizados+= b.getSaldo_puntos();
            if(puntosUtilizados + b.getSaldo_puntos() >= puntosRequeridos){
                break;
            }

        }

        Cabecera cabecera = new Cabecera();
        cabecera.setIdCliente(entidad.getIdCliente());
        cabecera.setPuntajeUtilizado(puntosRequeridos);

        if(puntosUtilizados < puntosRequeridos){
            throw new QueryException("No existen puntos suficientes");
        }


        //this.em.persist(entidad);

    }

}
