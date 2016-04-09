package transporte;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Coordenada
 *
 */
@Entity	
public class Coordenada implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "LATITUDE")
	private Long latitude;
	
	@Column(name = "LONGITUDE")
	private Long longitude;

	@OneToOne(mappedBy="coordenada")
	private Endereco endereco;

	private static final long serialVersionUID = 1L;

	public Coordenada() {
		super();
	}   
	public Long getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}   
	public Long getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}   

   
}
