package br.edu.mouralacerda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.mouralacerda.domain.Turma;
import br.edu.mouralacerda.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repository;

	public ResponseEntity<List<Turma>> getAll() {
		List<Turma> turmas = repository.findAll();
		return new ResponseEntity<List<Turma>>(turmas, HttpStatus.OK);
	}
	
	public ResponseEntity<Turma> getById(int id) {
		Optional<Turma> turma = repository.findById(id);
		if (!turma.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Turma>(turma.get(), HttpStatus.OK);
		}
	}
	
	public List<Turma> getByNome(String nome){
		return repository.findByNomeContainingIgnoreCase(nome);
	}

	public ResponseEntity<Turma> save(Turma turma) {
		return new ResponseEntity<Turma>(repository.save(turma), HttpStatus.CREATED);
	}

	public ResponseEntity<Turma> update(Turma turma, int id) {
		Optional<Turma> registro = repository.findById(id);
		if (!registro.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			turma.setId(registro.get().getId());
			return new ResponseEntity<Turma>(repository.save(turma), HttpStatus.OK);
		}
	}

	public ResponseEntity<?> delete(int id) {
		Optional<Turma> turma = repository.findById(id);

		if (!turma.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			repository.delete(turma.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
