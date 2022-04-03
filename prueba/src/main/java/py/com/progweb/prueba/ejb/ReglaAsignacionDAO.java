package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Persona;
import py.com.progweb.prueba.model.ReglaAsignacionPunto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ReglaAsignacionDAO {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(ReglaAsignacionPunto entidad) {
        this.em.persist(entidad);
    }

    public List<ReglaAsignacionPunto> lista() {
        Query q = this.em.createQuery("select p from ReglaAsignacionPunto p");
        return (List<ReglaAsignacionPunto>)q.getResultList();
    }

}
