package py.com.progweb.prueba.ejb;


import py.com.progweb.prueba.model.Cliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        System.out.println((List<Cliente>)q.getResultList());
        return (List<Cliente>)q.getResultList();
    }

}
