package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Detalle;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DetalleDAO {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(Detalle entidad) {

        this.em.persist(entidad);

    }

}
