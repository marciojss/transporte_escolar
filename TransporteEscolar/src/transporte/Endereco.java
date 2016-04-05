package transporte;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Endereco
 *
 */
@Entity

public class Endereco implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;

	@OneToOne(mappedBy="endereco")
	private Usuario usuario;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)
	@JoinColumn(name="coordenada_id", referencedColumnName="id")
	private Coordenada coordenada;
	
	@ManyToMany(mappedBy="itinerario")
	private List <Condutor> condutores; 
	private static final long serialVersionUID = 1L;

	public Endereco() {
		super();
	}   
	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}   
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}   
	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}   
	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}   
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}   

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
		coordenada.setEndereco(this);
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
