package py.com.progweb.prueba.ejb;

import org.hibernate.QueryException;
import py.com.progweb.prueba.model.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UsoPuntosDAO {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    ConceptoUsoPuntosDAO puntosDAO;
    BolsaPuntosDAO bolsaPuntosDAO;

    public void agregar(UsoPuntos entidad) {

        puntosDAO = new ConceptoUsoPuntosDAO();
        bolsaPuntosDAO = new BolsaPuntosDAO();
        Query qConcep = this.em.createQuery("select c from ConceptoUsoPuntos c WHERE c.idConceptoUsoPuntos = ?1");
        qConcep.setParameter(1, entidad.getIdConcepto());
        ConceptoUsoPuntos concepto = (ConceptoUsoPuntos) qConcep.getResultList();

        // Cantidad de puntos a utilizar
        int puntosRequeridos = concepto.getPuntosRequeridos();
        int puntosUtilizados = 0;

        // Bolsas disponibles para uso
        Query q = this.em.createQuery("select b from BolsaPuntos b where b.id_cliente = ?1 and b.saldo_puntos > ?2 order by b.fecha_asignacion asc" );
        q.setParameter(1, entidad.getIdCliente());
        q.setParameter(2, 0);
        List<BolsaPuntos> bolsas = (List<BolsaPuntos>)q.getResultList();

        // Lista de bolsas uilizadas
        ArrayList<BolsaPuntos> bolsasUtilizadas = new ArrayList<>();

        // Buscar todas las bolsas a utilizar para los puntos necesarios
        for(BolsaPuntos b : bolsas){
            bolsasUtilizadas.add(b);
            puntosUtilizados+= b.getSaldo_puntos();
            if(puntosUtilizados + b.getSaldo_puntos() >= puntosRequeridos){
                break;
            }

        }

        if(puntosUtilizados < puntosRequeridos){
            throw new QueryException("No existen puntos suficientes");
        }

        // Crear cabecera
        Cabecera cabecera = new Cabecera();
        cabecera.setIdCliente(entidad.getIdCliente());
        cabecera.setPuntajeUtilizado(puntosRequeridos);
        this.em.persist(cabecera);

        // Crear detalle
        Detalle detalle = new Detalle();
        detalle.setIdCabecera(cabecera.getIdCabecera());
        detalle.setPuntajeUtilizado(puntosRequeridos);
        this.em.persist(detalle);

        // Consumir puntos de las bolsas
        for(BolsaPuntos b : bolsasUtilizadas){
            if(b.getSaldo_puntos() - puntosRequeridos < 0){
                this.bolsaPuntosDAO.updatePuntos(b.getId_bolsa_puntos(), b.getSaldo_puntos());
            }
            else {
                this.bolsaPuntosDAO.updatePuntos(b.getId_bolsa_puntos(), puntosRequeridos);
            }
            // Enlazar detalle con bolsas utilizadas
            DetalleBolsaPuntosManytoMany m2m = new DetalleBolsaPuntosManytoMany();
            m2m.setIdDetalle(detalle.getIdDetalle());
            m2m.setIdBolsaPuntos(b.getId_bolsa_puntos());
            this.em.persist(m2m);
            puntosRequeridos-= b.getSaldo_puntos();
        }

    }

}
