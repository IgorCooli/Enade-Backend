package be.com.cesjf.enade.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode
@ToString
@Table(name = "tp_questao_tb")
public class TipoQuestao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tp_questao_id")
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy = "tipoQuestao")
	private List<Questao> questoes;

}
