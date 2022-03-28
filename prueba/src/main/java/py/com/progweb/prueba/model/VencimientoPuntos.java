package py.com.progweb.prueba.model;

import javax.persistence.*;
import java.sql.Date;

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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
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
