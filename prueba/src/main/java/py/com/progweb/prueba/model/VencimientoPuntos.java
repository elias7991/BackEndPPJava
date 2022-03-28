package py.com.progweb.prueba.model;

import javax.persistence.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "vencimiento_puntos")
public class VencimientoPuntos {

    @Id
    //como se llama en la base de datos
    @Column(name="id_vencimiento_puntos")
    @Basic(optional = false)
    @GeneratedValue(generator = "vencimientoSec", strategy = GenerationType.SEQUENCE)
    // sequenceName, como se llama en la base de datos
    // en name, como se llama el generador creado aqui
    @SequenceGenerator(name = "vencimientoSec", sequenceName = "sec_id_ven", allocationSize = 0)
    private Integer idVencimiento;
    @Column(name="fecha_inicio")
    @Basic(optional = false)
    private Date fechaInicio;
    @Column(name="fecha_fin")
    @Basic(optional = false)
    private Date fechaFin;
    @Column(name="dias_duracion")
    @Basic(optional = false)
    private int diasDuracion;

    public Integer getIdVencimiento() {
        return idVencimiento;
    }

    public void setIdVencimiento(Integer idVencimiento) {
        this.idVencimiento = idVencimiento;
    }

    public String getFechaInicio() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(fechaInicio);
        return strDate;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(fechaFin);
        return strDate;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getDiasDuracion() {
        return diasDuracion;
    }

    public void setDiasDuracion(int diasDuracion) {
        this.diasDuracion = diasDuracion;
    }
}
