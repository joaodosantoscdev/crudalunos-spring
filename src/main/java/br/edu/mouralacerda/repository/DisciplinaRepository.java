package br.edu.mouralacerda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.mouralacerda.domain.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer>{

	List<Disciplina> findByNomeContainingIgnoreCase(String nome);
}
