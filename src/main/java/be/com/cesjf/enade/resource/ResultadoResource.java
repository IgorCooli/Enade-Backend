package be.com.cesjf.enade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.com.cesjf.enade.dto.ResultadoDTO;
import be.com.cesjf.enade.model.Prova;
import be.com.cesjf.enade.model.Resultado;
import be.com.cesjf.enade.model.Usuario;
import be.com.cesjf.enade.repository.ProvaRepository;
import be.com.cesjf.enade.repository.ResultadoRepository;
import be.com.cesjf.enade.repository.UsuarioRepository;

@RestController
@RequestMapping("resultado")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResultadoResource {

	@Autowired
	ResultadoRepository repo;
	@Autowired
	ProvaRepository provaRepo;
	@Autowired
	UsuarioRepository usuarioRepo;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody ResultadoDTO dto){
		
		Prova prova = provaRepo.findById(dto.getProvaId()).get();
		Usuario usuario = usuarioRepo.findById(dto.getUsuarioId()).get();
		
		Resultado model = new Resultado();
		
		model.setProva(prova);
		model.setUsuario(usuario);
		model.setValorObtido(dto.getValorObtido());
		
		repo.save(model);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Resultado salvo com sucesso!!!");
		
	}
	
}
