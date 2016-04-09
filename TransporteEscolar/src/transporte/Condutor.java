package transporte;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Condutor
 *
 */
@Entity
@Table(name="CONDUTOR")
@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName="ID")
public class Condutor extends Usuario implements Serializable {

	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)
	@JoinColumn(name="veiculo_id", referencedColumnName="id")
	private Veiculo veiculo;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="itinerario", joinColumns={@JoinColumn(name="id_condutor")},
	inverseJoinColumns={@JoinColumn(name="id_endereco")})
	private List <Endereco> itinerario;


	private static final long serialVersionUID = 1L;

	public Condutor() {
		super();
	}   


	public List<Endereco> getItinerario() {
		return itinerario;
	}

	public void setItinerario(List<Endereco> itinerario) {
		this.itinerario = itinerario;
	}

   
}
