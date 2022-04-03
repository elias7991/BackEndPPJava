package py.com.progweb.prueba.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//ver errores

@Entity
@Table(name = "regla_asignacion_punto")
@NamedQueries({
	@NamedQuery(name = "ReglaAsignacionPunto.all", query = "SELECT rap FROM ReglaAsignacionPunto rap")
	,
	@NamedQuery(name = "ReglaAsignaconPunto.cantidadPuntos", query = "SELECT rap FROM ReglaAsignacionPunto rap where :monto>= rap.limiteInferior and :monto <= rap.limiteSuperior")})
public class ReglaAsignacionPunto {
	public ReglaAsignacionPunto() {
	}
	
	@Id
	@Column(name = "id")
	@Basic(optional = false)
	@GeneratedValue(generator = "reglaAsignacionPuntoSec", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "reglaAsignacionPuntoSec", sequenceName = "regla_asignacion_punto_sec", allocationSize = 0)
	private Integer id;
	
	@Column(name = "limite_inferior")
	@Basic(optional = false)
	private Integer limiteInferior;
	
	@Column(name = "limite_superior")
	@Basic(optional = false)
	private Integer limiteSuperior;
	
	@Column(name = "monto_equivalencia")
	@Basic(optional = false)
	private Integer montoEquivalencia;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getLimiteInferior() {
		return limiteInferior;
	}
	
	public void setLimiteInferior(Integer limiteInferior) {
		this.limiteInferior = limiteInferior;
	}
	
	public Integer getLimiteSuperior() {
        return limiteSuperior;
    }
	
	public void setLimiteSuperior(Integer limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
	}
	
	public Integer getMontoEquivalencia() {
		return montoEquivalencia;
	}
	
	public void setMontoEquivalencia(Integer montoEquivalencia) {
		this.montoEquivalencia = montoEquivalencia;
	}
	
	@Override
	public String toString() {
		return "ReglaAsignacionPunto{" + "id=" + id + ", limiteInferior=" + limiteInferior + ", limiteSuperior=" + limiteSuperior + ", montoEquivalencia=" + montoEquivalencia + '}';
	}	

}
