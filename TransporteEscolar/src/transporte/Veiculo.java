package transporte;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

public class Veiculo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NUM_ORDEM", unique=true)
	private int num_ordem;

	
	@Column(name = "MODELO")
	private String modelo;
	
	@Column(name = "QTD_ASSENTOS")
	private String qtd_assentos;

	
	@OneToOne(mappedBy="Veiculo")
	private Condutor condutor;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getQtd_assentos() {
		return qtd_assentos;
	}

	public void setQtd_assentos(String qtd_assentos) {
		this.qtd_assentos = qtd_assentos;
	}
}
