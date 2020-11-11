package be.com.cesjf.enade.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questao_tb")
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "questao_id")
	private Long id;
		
	private String descricao;
	
	@Column(name = "alternativa_a")
	private String alternativaA;

	@Column(name = "alternativa_b")
	private String alternativaB;

	@Column(name = "alternativa_c")
	private String alternativaC;

	@Column(name = "alternativa_d")
	private String alternativaD;

	@Column(name = "alternativa_e")
	private String alternativaE;
	
	@Column(name = "questao_correta")
	private String questaoCorreta;
	
	@ManyToOne
	@JoinColumn(name = "tp_questao_id")
	private TipoQuestao tipoQuestao;
	
	@ManyToMany(mappedBy = "questoes")
	private List<Prova> provas;
	
}
