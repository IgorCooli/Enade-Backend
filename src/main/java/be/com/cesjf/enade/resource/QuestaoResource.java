package be.com.cesjf.enade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.com.cesjf.enade.repository.QuestaoRepository;

@RestController
@RequestMapping("questao")
public class QuestaoResource {

	@Autowired
	QuestaoRepository repo;
	
}
