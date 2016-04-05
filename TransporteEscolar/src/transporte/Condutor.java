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
public class Condutor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String login;
	private String password;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="itinerario", joinColumns={@JoinColumn(name="id_condutor")},
	inverseJoinColumns={@JoinColumn(name="id_endereco")})
	private List <Endereco> itinerario;


	private static final long serialVersionUID = 1L;

	public Condutor() {
		super();
	}   

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Endereco> getItinerario() {
		return itinerario;
	}

	public void setItinerario(List<Endereco> itinerario) {
		this.itinerario = itinerario;
	}

   
}
