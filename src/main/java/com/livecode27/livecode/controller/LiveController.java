package com.livecode27.livecode.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livecode27.livecode.model.Live;
import com.livecode27.livecode.repository.LiveRepository;

@RestController
@RequestMapping("/live")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class LiveController {
	
	@Autowired
	private LiveRepository repository;
	
	@GetMapping //Abre uma porta no metodo/end point ao chamar um verbo Get
	public ResponseEntity<List<Live>> getAll(){ //ResponseEntity Cria um objeto padrão HTTP/s
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Live> getById(@PathVariable long id){	
		
		/*O metodo findbyId(id) retorna um optional, podendo conter detro dele o objeto ou não
		 * 
		 * neste caso usamos o .map para varrer o optional e ver se tem algo dentro caso não 
		 * 
		 * usamos o orElse para retornar uma mensagem de erro!!!
		 * */
		
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());	
		
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Live>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findByNomeContainingIgnoreCase(nome));
	}
	
	
	@PostMapping
	public ResponseEntity<Live> post(@Valid @RequestBody Live batatinha){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(batatinha));
	}
	
	@PutMapping
	public ResponseEntity<Live> put(@Valid @RequestBody Live batatinha){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(batatinha));
	}

	
}
