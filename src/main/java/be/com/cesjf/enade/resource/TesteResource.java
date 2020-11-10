package be.com.cesjf.enade.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteResource {
	
	@GetMapping("/hello")
	public ResponseEntity<?> hello(){
		return ResponseEntity.status(HttpStatus.OK).body("Hello World!!!");
	}

}
