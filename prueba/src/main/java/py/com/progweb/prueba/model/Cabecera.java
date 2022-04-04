package py.com.progweb.prueba.model;

import javax.persistence.*;
import java.sql.Date;

@Entity

@Table(name="cabecera_uso_puntos")
public class Cabecera {

    @Id
    //como se llama en la base de datos
    @Column(name="id_cabecera_uso_puntos")
    @Basic(optional = false)
    @GeneratedValue(generator = "cabeceraSec", strategy = GenerationType.SEQUENCE)
    // sequenceName, como se llama en la base de datos
    // en name, como se llama el generador creado aqui
    @SequenceGenerator(name = "cabeceraSec", sequenceName = "sec_cabecera_uso_puntos", allocationSize = 0)
    private Integer idCabecera;

    // foreign key
    @Column(name="id_cliente")
    @Basic(optional = false)
    private Integer idCliente;
    @Column(name="id_concepto_puntos")
    @Basic(optional = false)
    private Integer idConceptoPuntos;

    @Column(name="puntaje_utilizado")
    @Basic(optional = false)
    private Integer puntajeUtilizado;

    @Column(name="fecha_uso")
    @Basic(optional = false)
    private Date fechaUso;

    public Integer getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(Integer idCabecera) {
        this.idCabecera = idCabecera;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdConceptoPuntos() {
        return idConceptoPuntos;
    }

    public void setIdConceptoPuntos(Integer idConceptoPuntos) {
        this.idConceptoPuntos = idConceptoPuntos;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Date getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(Date fechaUso) {
        this.fechaUso = fechaUso;
    }
}
