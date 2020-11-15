package be.com.cesjf.enade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.com.cesjf.enade.dto.QuestaoDTO;
import be.com.cesjf.enade.model.Questao;
import be.com.cesjf.enade.repository.QuestaoRepository;
import be.com.cesjf.enade.repository.TipoQuestaoRepository;

@RestController
@RequestMapping("questao")
public class QuestaoResource {

	@Autowired
	QuestaoRepository repo;
	@Autowired
	TipoQuestaoRepository tpQuestaorepo;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveQuestao(@RequestBody QuestaoDTO dto){
		
		Questao model = new Questao();
		
		model.setAlternativaA(dto.getAlternativaA());
		model.setAlternativaB(dto.getAlternativaB());
		model.setAlternativaC(dto.getAlternativaC());
		model.setAlternativaD(dto.getAlternativaD());
		model.setAlternativaE(dto.getAlternativaE());
		model.setDescricao(dto.getDescricao());
		model.setEstado(1);
		model.setTipoQuestao(tpQuestaorepo.findByNome(dto.getTipoQuestao()));
		model.setQuestaoCorreta(dto.getQuestaoCorreta());
		
		repo.save(model);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Questão cadastrada com sucesso!!!");
		
	}
	
	@GetMapping("/findall")
	public ResponseEntity<?> questaoFindAll(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repo.findAllQuestao());
	}
	
}
