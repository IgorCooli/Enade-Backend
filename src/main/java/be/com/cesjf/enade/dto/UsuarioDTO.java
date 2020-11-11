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
public class UsuarioDTO {
	
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String tipo;

}
