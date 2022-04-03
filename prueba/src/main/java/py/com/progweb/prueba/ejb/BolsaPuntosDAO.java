package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.BolsaPuntos;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public void update(BolsaPuntos entidad, int id) throws ParseException {

        BolsaPuntos e = this.em.find(BolsaPuntos.class, id);
        e.setId_cliente(entidad.getId_cliente());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // pasamos de String a Date de sql
        java.util.Date fecha_asignacion = format.parse(entidad.getFecha_asignacion());
        Date sqlAsignacion = new Date(fecha_asignacion.getTime());
        e.setFecha_asignacion(sqlAsignacion);
        // pasamos de String a Date de sql
        java.util.Date fecha_caducidad = format.parse(entidad.getFecha_caducidad());
        Date sqlCaducidad = new Date(fecha_caducidad.getTime());
        e.setFecha_caducidad(sqlCaducidad);
        e.setPuntos_totales(entidad.getPuntos_totales());
        e.setPuntos_utilizados(entidad.getPuntos_utilizados());
        e.setSaldo_puntos(entidad.getSaldo_puntos());
        e.setMonto_operacion(entidad.getMonto_operacion());

        this.em.merge(e);

    }

    public void delete(int id){

        BolsaPuntos e = this.em.find(BolsaPuntos.class, id);

        Query q = this.em.createQuery("DELETE from BolsaPuntos bp WHERE bp.id_bolsa_puntos =" + id);
        q.executeUpdate();

    }
}