package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Cliente;
import py.com.progweb.prueba.model.VencimientoPuntos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Stateless
public class VencimientoPuntosDAO {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(VencimientoPuntos entidad) {

        int days = (int) ((entidad.getFechaFin().getTime()-entidad.getFechaInicio().getTime())/86400000);
        entidad.setDiasDuracion(days);
        this.em.persist(entidad);

    }

    public List<VencimientoPuntos> lista() {
        Query q = this.em.createQuery("select c from VencimientoPuntos c");

        return (List<VencimientoPuntos>)q.getResultList();
    }

    public void update(VencimientoPuntos entidad, int id) throws ParseException {

        VencimientoPuntos e = this.em.find(VencimientoPuntos.class, id);
        e.setFechaInicio(entidad.getFechaInicio());
        e.setFechaFin(entidad.getFechaFin());
        e.setDiasDuracion((int) ((entidad.getFechaFin().getTime()-entidad.getFechaInicio().getTime())/86400000));

        this.em.merge(e);

    }

    public void delete(int id){

        VencimientoPuntos e = this.em.find(VencimientoPuntos.class, id);

        Query q = this.em.createQuery("DELETE from VencimientoPuntos c WHERE c.idVencimiento =" + id);
        q.executeUpdate();

    }

}
