package be.com.cesjf.enade.dto;

import java.util.List;

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
public class ProvaDTO {
	
	private Long id;
	
	private String data;
	
	private List<QuestaoDTO> questoes;

}
