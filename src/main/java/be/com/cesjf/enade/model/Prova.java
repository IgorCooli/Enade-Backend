package be.com.cesjf.enade.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode
@ToString
@Table(name = "prova_tb")
public class Prova {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prova_id")
	private Long id;
	
	@Column(name = "data_prova")
	private Date dataProva;
	
	@ManyToMany
	@JoinTable(
		name = "prova_questao_tb",
		joinColumns = @JoinColumn(name = "prova_id"), inverseJoinColumns = @JoinColumn(name = "questao_id")
	)
	private List<Questao> questoes;

}
