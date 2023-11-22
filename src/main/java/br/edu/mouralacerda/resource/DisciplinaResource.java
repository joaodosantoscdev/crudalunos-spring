package br.edu.mouralacerda.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.mouralacerda.domain.Disciplina;
import br.edu.mouralacerda.service.DisciplinaService;

@RestController
@CrossOrigin(origins = "*")
public class DisciplinaResource {
	@Autowired
	private DisciplinaService service;	
	
	@GetMapping("disciplinas")
	public ResponseEntity<List<Disciplina>> getAll(){
		return service.getAll();
	}
	
	@GetMapping("disciplinas/{id}")
	public Disciplina getById(@PathVariable int id){
		return service.getById(id);
	}
	
	@PostMapping("disciplinas/find")
	public List<Disciplina> getByNome(@RequestBody String nome){
		return service.getByNome(nome);
	}
	
	@PostMapping("disciplinas")
	public ResponseEntity<Disciplina> save(@RequestBody Disciplina disciplina) {
		return service.save(disciplina);
	}
	
	@PutMapping("disciplinas/{id}")
	public ResponseEntity<Disciplina> update(@RequestBody Disciplina disciplina, @PathVariable int id) {
		return service.update(disciplina, id);
	}
	
	@DeleteMapping("disciplinas/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		return service.delete(id);
	}
}
