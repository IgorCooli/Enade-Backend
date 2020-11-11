package be.com.cesjf.enade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.com.cesjf.enade.repository.ProvaRepository;

@RestController
@RequestMapping("/prova")
public class ProvaResource {
	
	@Autowired
	ProvaRepository repo;
	
}
