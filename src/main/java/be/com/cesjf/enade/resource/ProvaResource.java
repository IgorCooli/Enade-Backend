package be.com.cesjf.enade.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

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

import be.com.cesjf.enade.dto.ProvaDTO;
import be.com.cesjf.enade.dto.QuestaoDTO;
import be.com.cesjf.enade.model.Prova;
import be.com.cesjf.enade.model.Questao;
import be.com.cesjf.enade.repository.ProvaRepository;
import be.com.cesjf.enade.repository.TipoQuestaoRepository;

@RestController
@RequestMapping("/prova")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProvaResource {
	
	@Autowired
	ProvaRepository repo;
	@Autowired
	TipoQuestaoRepository tpQuestaorepo;
	
	@GetMapping("/findall")
	public ResponseEntity<?> findAllProva(){
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAllProva());
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody ProvaDTO dto) throws Exception{
		
		Prova model = new Prova();
		
		List<Questao> lista = new ArrayList<Questao>();
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));

		java.util.Date date = format.parse(dto.getData());

		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		model.setDataProva(sqlDate);

		
		for (QuestaoDTO questao : dto.getQuestoes()) {
			
			Questao questaoModel = new Questao();
			questaoModel.setId(questao.getId());
			questaoModel.setAlternativaA(questao.getAlternativaA());
			questaoModel.setAlternativaB(questao.getAlternativaB());
			questaoModel.setAlternativaC(questao.getAlternativaC());
			questaoModel.setAlternativaD(questao.getAlternativaD());
			questaoModel.setAlternativaE(questao.getAlternativaE());
			questaoModel.setDescricao(questao.getDescricao());
			questaoModel.setEstado(questao.getEstado()); 
			questaoModel.setTipoQuestao(tpQuestaorepo.findById(questao.getTipoQuestao()).orElse(null));
			questaoModel.setQuestaoCorreta(questao.getQuestaoCorreta());
			
			lista.add(questaoModel);
			
		}
		
		model.setQuestoes(lista);
		repo.save(model);
		
		return ResponseEntity.status(HttpStatus.OK).body("teste");
		
	}
	
	@GetMapping("/findquestoes/{id}")
	public ResponseEntity<?> findQuestoes(@PathVariable Long id){
		Prova prova = new Prova();
		prova = repo.findById(id).orElseThrow();
		List<QuestaoDTO> lista = new ArrayList<QuestaoDTO>();
		for (Questao questao : prova.getQuestoes()) {
			QuestaoDTO dto = new QuestaoDTO();
			dto.setAlternativaA(questao.getAlternativaA());
			dto.setAlternativaB(questao.getAlternativaB());
			dto.setAlternativaC(questao.getAlternativaC());
			dto.setAlternativaD(questao.getAlternativaD());
			dto.setAlternativaE(questao.getAlternativaE());
			dto.setDescricao(questao.getDescricao());
			dto.setEstado(questao.getEstado());
			dto.setId(questao.getId());
			dto.setQuestaoCorreta(questao.getQuestaoCorreta());
			dto.setTipoQuestao(questao.getTipoQuestao().getId());
			lista.add(dto);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
}
