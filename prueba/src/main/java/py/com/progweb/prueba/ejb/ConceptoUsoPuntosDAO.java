package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Cliente;
import py.com.progweb.prueba.model.ConceptoUsoPuntos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Stateless
public class ConceptoUsoPuntosDAO {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(ConceptoUsoPuntos entidad) {

        this.em.persist(entidad);

    }

    public List<Cliente> lista() {
        Query q = this.em.createQuery("select c from ConceptoUsoPuntos c");

        return (List<Cliente>)q.getResultList();
    }

    public void update(ConceptoUsoPuntos entidad, int id) throws ParseException {

        ConceptoUsoPuntos e = this.em.find(ConceptoUsoPuntos.class, id);
        e.setDescripcion(entidad.getDescripcion());
        e.setPuntosRequeridos(entidad.getPuntosRequeridos());

        this.em.merge(e);

    }

    public void delete(int id){

        Query q = this.em.createQuery("DELETE from ConceptoUsoPuntos c WHERE c.idConceptoUsoPuntos =" + id);
        q.executeUpdate();

    }

}
