package py.com.progweb.prueba.model;

import javax.persistence.*;
import java.sql.Date;

@Entity

@Table(name="concepto_puntos")
public class ConceptoUsoPuntos {

    @Id
    //como se llama en la base de datos
    @Column(name="id_concepto_puntos")
    @Basic(optional = false)
    @GeneratedValue(generator = "usopuntosSec", strategy = GenerationType.SEQUENCE)
    // sequenceName, como se llama en la base de datos
    // en name, como se llama el generador creado aqui
    @SequenceGenerator(name = "usopuntosSec", sequenceName = "sec_concepto_puntos", allocationSize = 0)
    private Integer idConceptoUsoPuntos;
    @Column(name="descripcion", length=50)
    @Basic(optional = false)
    private String descripcion;
    @Column(name="puntos_requeridos", length=50)
    @Basic(optional = false)
    private int PuntosRequeridos;

    public Integer getIdConceptoUsoPuntos() {
        return idConceptoUsoPuntos;
    }

    public void setIdConceptoUsoPuntos(Integer idConceptoUsoPuntos) {
        this.idConceptoUsoPuntos = idConceptoUsoPuntos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntosRequeridos() {
        return PuntosRequeridos;
    }

    public void setPuntosRequeridos(int puntosRequeridos) {
        PuntosRequeridos = puntosRequeridos;
    }
}
