package br.edu.mouralacerda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.mouralacerda.domain.Disciplina;
import br.edu.mouralacerda.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	@Autowired
	private DisciplinaRepository repository;

	public ResponseEntity<List<Disciplina>> getAll() {
		List<Disciplina> disciplinas = repository.findAll();
		return new ResponseEntity<List<Disciplina>>(disciplinas, HttpStatus.OK);
	}
	
	public Disciplina getById(int id) {
		return repository.findById(id).get();
	}
	
	public List<Disciplina> getByNome(String nome){
		return repository.findByNomeContainingIgnoreCase(nome);
	}

	public ResponseEntity<Disciplina> save(Disciplina disciplina) {
		return new ResponseEntity<Disciplina>(repository.save(disciplina), HttpStatus.CREATED);
	}

	public ResponseEntity<Disciplina> update(Disciplina disciplina, int id) {
		Optional<Disciplina> registro = repository.findById(id);
		if (!registro.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			disciplina.setId(registro.get().getId());
			return new ResponseEntity<Disciplina>(repository.save(disciplina), HttpStatus.OK);
		}
	}

	public ResponseEntity<?> delete(int id) {
		Optional<Disciplina> disciplina = repository.findById(id);

		if (!disciplina.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			repository.delete(disciplina.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
