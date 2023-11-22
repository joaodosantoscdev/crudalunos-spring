package br.edu.mouralacerda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.mouralacerda.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{
	List<Turma> findByNomeContainingIgnoreCase(String nome);
}
