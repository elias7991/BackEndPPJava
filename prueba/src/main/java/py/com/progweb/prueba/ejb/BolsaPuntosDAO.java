package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.BolsaPuntos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class BolsaPuntosDAO {

    // con esto sabrá con que base de datos hará su trabajo
    @PersistenceContext(unitName="pruebaPU")
    private EntityManager em;

    public void agregar(BolsaPuntos entidad){
        this.em.persist(entidad);
    }

    public List<BolsaPuntos> lista(){
        Query q = this.em.createQuery("select b from BolsaPuntos b");
        return (List<BolsaPuntos>)q.getResultList();
    }

}