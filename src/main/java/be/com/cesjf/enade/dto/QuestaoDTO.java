package be.com.cesjf.enade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QuestaoDTO {

	private Long id;
		
	private String descricao;
	
	private String alternativaA;

	private String alternativaB;

	private String alternativaC;

	private String alternativaD;

	private String alternativaE;
	
	private String questaoCorreta;
	
	private String tipoQuestao;
	
	private int estado;

}
