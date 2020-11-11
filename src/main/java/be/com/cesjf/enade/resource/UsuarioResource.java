package be.com.cesjf.enade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.com.cesjf.enade.dto.LoginDTO;
import be.com.cesjf.enade.dto.UsuarioDTO;
import be.com.cesjf.enade.model.Usuario;
import be.com.cesjf.enade.repository.TipoUsuarioRepository;
import be.com.cesjf.enade.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	UsuarioRepository repo;
	
	@Autowired
	TipoUsuarioRepository tpUsuarioRepo;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUsuario(@RequestBody UsuarioDTO dto){
		Usuario model = new Usuario();
		
		model.setEmail(dto.getEmail());
		model.setNome(dto.getNome());
		model.setSenha(dto.getSenha());
		model.setTipo(tpUsuarioRepo.findByNome(dto.getTipo()));
		
		repo.save(model);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!!!");
		
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findUsuarioById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(repo.findUsuarioById(id));
	}
	
	@GetMapping("/findall")
	public ResponseEntity<?> findAllUsuario(){
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAllUsuario());
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
		
		UsuarioDTO dto = new UsuarioDTO();
		
		dto = repo.login(loginDTO.getEmail(), loginDTO.getSenha());
		
		if(dto!=null) {
			return ResponseEntity.status(HttpStatus.OK).body("Logado com sucesso!!!");
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado!!!");
		}
		
	}
	
}
