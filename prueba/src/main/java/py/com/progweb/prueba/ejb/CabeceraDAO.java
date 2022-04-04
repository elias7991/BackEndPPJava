package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Cabecera;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CabeceraDAO {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(Cabecera entidad) {

        this.em.persist(entidad);

    }

}
