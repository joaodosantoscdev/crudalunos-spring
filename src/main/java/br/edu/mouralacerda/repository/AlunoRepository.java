package br.edu.mouralacerda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.mouralacerda.domain.Aluno;
import br.edu.mouralacerda.domain.AlunoDisciplina;

@Repository
public interface AlunoRepository extends
JpaRepository<Aluno, Integer> {

	List<Aluno> findByNomeContainingIgnoreCase(String nome);

	@Query("SELECT ad FROM AlunoDisciplina ad JOIN ad.disciplina d WHERE ad.aluno.id = :alunoId")
	List<AlunoDisciplina> selectDisciplinasByAlunoId(@Param("alunoId") int alunoId);
}
