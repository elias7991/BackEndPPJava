package py.com.progweb.prueba.model;

import javax.persistence.*;

@Entity

@Table(name="detalles_bolsas")
public class DetalleBolsaPuntosManytoMany {

    @Id
    //como se llama en la base de datos
    @Column(name="id_detalles_bolsas")
    @Basic(optional = false)
    @GeneratedValue(generator = "detalleBolsaMtoMSec", strategy = GenerationType.SEQUENCE)
    // sequenceName, como se llama en la base de datos
    // en name, como se llama el generador creado aqui
    @SequenceGenerator(name = "detalleBolsaMtoMSec", sequenceName = "sec_detalles_bolsas", allocationSize = 0)
    private Integer idDetallesBolsas;

    // foreign key
    @Column(name="id_detalle")
    @Basic(optional = false)
    private Integer idDetalle;

    @Column(name="id_bolsa_puntos")
    @Basic(optional = false)
    private Integer idBolsaPuntos;

    public Integer getIdDetallesBolsas() {
        return idDetallesBolsas;
    }

    public void setIdDetallesBolsas(Integer idDetallesBolsas) {
        this.idDetallesBolsas = idDetallesBolsas;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdBolsaPuntos() {
        return idBolsaPuntos;
    }

    public void setIdBolsaPuntos(Integer idBolsaPuntos) {
        this.idBolsaPuntos = idBolsaPuntos;
    }
}
