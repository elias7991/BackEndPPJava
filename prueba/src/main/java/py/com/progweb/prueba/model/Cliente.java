package py.com.progweb.prueba.model;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.Min;
import java.sql.Date;

@Entity

@Table(name="cliente")
public class Cliente {

    @Id
    //como se llama en la base de datos
    @Column(name="id_cliente")
    @Basic(optional = false)
    @GeneratedValue(generator = "clienteSec", strategy = GenerationType.SEQUENCE)
    // sequenceName, como se llama en la base de datos
    // en name, como se llama el generador creado aqui
    @SequenceGenerator(name = "clienteSec", sequenceName = "sec_id_cliente", allocationSize = 0)
    private Integer idCliente;
    @Column(name="nombre_cliente", length=50)
    @Basic(optional = false)
    private String nombre;
    @Column(name="apellido_cliente", length=50)
    @Basic(optional = false)
    private String apellido;
    @Column(name="nro_documento", unique = true)
    @Basic(optional = false)
    private int nroDocumneto;
    @Column(name="tipo_documento", length=50)
    @Basic(optional = false)
    private String tipoDocumento;
    @Column(name="nacionalidad", length=50)
    private String nacionalidad;
    @Column(name="email", unique = true)
    private String email;
    @Column(name="telefono")
    private String telefono;
    @Column(name="fecha_nacimiento")
    @Basic(optional = false)
    private Date fechaNacimiento;

    public Cliente() {

    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNroDocumneto() {
        return nroDocumneto;
    }

    public void setNroDocumneto(int nroDocumneto) {
        this.nroDocumneto = nroDocumneto;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
