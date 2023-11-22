package br.edu.mouralacerda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.mouralacerda.domain.AlunoDisciplina;

@Repository
public interface AlunoDisciplinaRepository extends
JpaRepository<AlunoDisciplina, Integer> {

}
