package br.org.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.domain.Livro;
import br.org.serratec.repository.LivroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Livro>> listar(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id){
		return repository.findById(id).isPresent()? ResponseEntity.ok(repository.findById(id).get())
				:ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro inserir(@Valid @RequestBody Livro livro) {
		return repository.save(livro);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizar(@PathVariable Long id, @Valid @RequestBody Livro livro){
		livro.setId(id);
		return repository.existsById(id)?ResponseEntity.ok(repository.save(livro))
				:ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
}
