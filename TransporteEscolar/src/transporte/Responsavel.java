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

public class Responsavel extends Usuario implements Serializable {

	
	@OneToOne(mappedBy="Aluno")
	private Aluno aluno;
}
