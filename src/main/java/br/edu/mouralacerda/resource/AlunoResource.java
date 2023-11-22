package br.edu.mouralacerda.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.mouralacerda.domain.Aluno;
import br.edu.mouralacerda.domain.AlunoDisciplina;
import br.edu.mouralacerda.service.AlunoService;

@RestController
@CrossOrigin(origins = "*")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;

	@GetMapping("alunos")
	public List<Aluno> getAll() {
		return service.selectAll();
	}
	
	@GetMapping("alunos/{id}")
	public Aluno getById(@PathVariable int id) {
		return service.selectById(id);
	}

	@GetMapping("alunos/disciplinas/{alunoId}")
	public List<AlunoDisciplina> getByAlunoId(@PathVariable int alunoId) {
		return service.selectByAlunoId(alunoId);
	}
	
	@PostMapping("alunos/find")
	public List<Aluno> getByNome(@RequestBody String nome){
		return service.selectByNome(nome);
	}
	
	@PostMapping("alunos")
	public String create(@RequestBody Aluno aluno) {
		return service.insert(aluno);
	}
	
	@PutMapping("alunos/{id}")
	public String update(@PathVariable int id,
						 @RequestBody Aluno aluno) {
		return service.update(id, aluno);
	}
	
	@DeleteMapping("alunos/{id}")
	public String Delete(@PathVariable int id) {
		return service.delete(id);
	}
	
	@GetMapping("alunos/associarDisciplina/{idAluno}/{idDisciplina}")
	public String associarDisciplina(@PathVariable int idAluno, @PathVariable int idDisciplina) {
		return service.associarDisciplina(idAluno, idDisciplina);
	}
	
	@GetMapping("alunos/desassociarDisciplina/{idAluno}/{idDisciplina}")
	public String desassociarDisciplina(@PathVariable int idAluno, @PathVariable int idDisciplina) {
		return service.desassociarDisciplina(idAluno, idDisciplina);
	}
}
