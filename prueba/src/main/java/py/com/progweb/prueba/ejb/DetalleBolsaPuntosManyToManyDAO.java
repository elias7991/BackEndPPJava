package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.BolsaPuntos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DetalleBolsaPuntosManyToManyDAO {

    @PersistenceContext(unitName="pruebaPU")
    private EntityManager em;

    public void agregar(BolsaPuntos entidad){
        this.em.persist(entidad);
    }


}
