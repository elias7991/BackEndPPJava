package py.com.progweb.prueba.ejb;


import py.com.progweb.prueba.model.Cliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Stateless
public class ClienteDAO {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(Cliente entidad) {

        this.em.persist(entidad);

    }

    public List<Cliente> lista() {
        Query q = this.em.createQuery("select c from Cliente c");

        return (List<Cliente>)q.getResultList();
    }

}
