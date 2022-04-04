package py.com.progweb.prueba.model;

import javax.persistence.*;
import java.sql.Date;

@Entity

@Table(name="detalle_uso_puntos")
public class Detalle {

    @Id
    //como se llama en la base de datos
    @Column(name="id_detalle_uso_puntos")
    @Basic(optional = false)
    @GeneratedValue(generator = "detalleSec", strategy = GenerationType.SEQUENCE)
    // sequenceName, como se llama en la base de datos
    // en name, como se llama el generador creado aqui
    @SequenceGenerator(name = "detalleSec", sequenceName = "sec_detalle_uso_puntos", allocationSize = 0)
    private Integer idDetalle;

    // foreign key
    @Column(name="id_cabecera_uso_puntos")
    @Basic(optional = false)
    private Integer idCabecera;

    @Column(name="puntaje_utilizado")
    @Basic(optional = false)
    private Integer puntajeUtilizado;

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(Integer idCabecera) {
        this.idCabecera = idCabecera;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }
}
