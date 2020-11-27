package be.com.cesjf.enade.dto;

import javax.persistence.Entity;

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
public class ResultadoDTO {

	private double valorObtido;
	
	private Long usuarioId;
	
	private Long provaId;

}
