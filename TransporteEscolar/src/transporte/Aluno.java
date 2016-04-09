package transporte;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Aluno extends Usuario implements Serializable {

	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)
	@JoinColumn(name="endereco_id", referencedColumnName="id")
	private Endereco endereco;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)
	@JoinColumn(name="responsavel_id", referencedColumnName="id")
	private Responsavel responsavel;
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
		endereco.setUsuario(this);
	}

	
}
