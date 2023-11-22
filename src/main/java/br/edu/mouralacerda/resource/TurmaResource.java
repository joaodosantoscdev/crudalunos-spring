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

import br.edu.mouralacerda.domain.Turma;
import br.edu.mouralacerda.service.TurmaService;

@RestController
@CrossOrigin(origins = "*")
public class TurmaResource {

	@Autowired
	private TurmaService service;	
	
	@GetMapping("turmas")
	public ResponseEntity<List<Turma>> getAll(){
		return service.getAll();
	}
	
	@GetMapping("turmas/{id}")
	public ResponseEntity<Turma> getById(@PathVariable int id){
		return service.getById(id);
	}
	
	@PostMapping("turmas/find")
	public List<Turma> getByNome(@RequestBody String nome){
		return service.getByNome(nome);
	}
	
	@PostMapping("turmas")
	public ResponseEntity<Turma> save(@RequestBody Turma turma) {
		return service.save(turma);
	}
	
	@PutMapping("turmas/{id}")
	public ResponseEntity<Turma> update(@RequestBody Turma turma, @PathVariable int id) {
		return service.update(turma, id);
	}
	
	@DeleteMapping("turmas/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		return service.delete(id);
	}
}
