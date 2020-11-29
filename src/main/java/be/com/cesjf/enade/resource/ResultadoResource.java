package be.com.cesjf.enade.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.com.cesjf.enade.dto.ResultadoDTO;
import be.com.cesjf.enade.dto.UsuarioResultadoDTO;
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
	
	@GetMapping("/confereresultado/{provaId}/{usuarioId}")
	public ResponseEntity<?> confereResultado(@PathVariable Long provaId, @PathVariable Long usuarioId){
		ResultadoDTO dto = repo.confereResultado(usuarioId, provaId);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@GetMapping("/findultimosdezalunos/{provaId}")
	public ResponseEntity<?> findUltimosDezAlunos(@PathVariable Long provaId){
		
		List<UsuarioResultadoDTO> lista = repo.findUltimosDezAlunos(provaId);
		
		List<UsuarioResultadoDTO> ultimos10 = new ArrayList<>();
		
		if(lista.size()<=10) {
			ultimos10 = lista;
		}else {
			for(int i=0 ; i<= 9 ; i++) {
				ultimos10.add(lista.get(i));
			}
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(ultimos10);
		
	}
	
}
