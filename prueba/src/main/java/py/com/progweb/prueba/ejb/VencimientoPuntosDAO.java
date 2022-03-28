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

    public void agregar(VencimientoPuntos entidad) throws ParseException {
        // Format para pasar de String a date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int days = (int) ((format.parse(entidad.getFechaFin()).getTime()-format.parse(entidad.getFechaInicio()).getTime())/86400000);
        entidad.setDiasDuracion(days);
        this.em.persist(entidad);

    }

    public List<VencimientoPuntos> lista() {
        Query q = this.em.createQuery("select c from VencimientoPuntos c");

        return (List<VencimientoPuntos>)q.getResultList();
    }

    public void update(VencimientoPuntos entidad, int id) throws ParseException {
        // Format para pasar de String a date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        VencimientoPuntos e = this.em.find(VencimientoPuntos.class, id);
        e.setFechaInicio(new Date(format.parse(entidad.getFechaInicio()).getTime()));
        e.setFechaFin(new Date(format.parse(entidad.getFechaFin()).getTime()));
        e.setDiasDuracion((int) ((format.parse(entidad.getFechaFin()).getTime()-format.parse(entidad.getFechaInicio()).getTime())/86400000) );

        this.em.merge(e);

    }

    public void delete(int id){

        VencimientoPuntos e = this.em.find(VencimientoPuntos.class, id);

        Query q = this.em.createQuery("DELETE from VencimientoPuntos c WHERE c.idVencimiento =" + id);
        q.executeUpdate();

    }

}
