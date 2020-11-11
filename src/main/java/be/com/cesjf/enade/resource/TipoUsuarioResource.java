package be.com.cesjf.enade.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.com.cesjf.enade.dto.TipoUsuarioDTO;
import be.com.cesjf.enade.model.TipoUsuario;
import be.com.cesjf.enade.repository.TipoUsuarioRepository;

@RestController
@RequestMapping("/tipousuario")
public class TipoUsuarioResource {

	@Autowired
	TipoUsuarioRepository repo;
	
	@PostMapping("/savetipousuario")
	public ResponseEntity<?> saveTipoUsuario(@RequestBody TipoUsuarioDTO dto) {
		
		TipoUsuario model = new TipoUsuario();
		
		model.setNome(dto.getNome());
		
		repo.save(model);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Usuário salvo com sucesso!!!");
	}
	
	@GetMapping("/findtipousuariobyid/{id}")
	public ResponseEntity<?> findTipoUsuarioById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(repo.findById(id));
	}
	
	@GetMapping("/findalltipousuario")
	public ResponseEntity<?> findAllTipoUsuario(){
		
		List<TipoUsuarioDTO> list = new ArrayList<>();
		
		for (TipoUsuario model : repo.findAll()) {
			
			TipoUsuarioDTO dto = new TipoUsuarioDTO();
			
			dto.setId(model.getId());
			
			dto.setNome(model.getNome());
			
			list.add(dto);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
}
