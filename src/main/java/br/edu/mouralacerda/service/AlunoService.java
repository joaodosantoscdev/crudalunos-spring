package br.edu.mouralacerda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.mouralacerda.domain.Aluno;
import br.edu.mouralacerda.domain.AlunoDisciplina;
import br.edu.mouralacerda.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> selectAll(){
		return repository.findAll();
	}
	
	public Aluno selectById(int id) {
		Aluno aluno = repository.findById(id).get();
		
		return aluno;
	}

	public List<AlunoDisciplina> selectByAlunoId(int alunoId) {
		List<AlunoDisciplina> disciplina = repository.selectDisciplinasByAlunoId(alunoId);
		
		return disciplina;
	}
	
	public List<Aluno> selectByNome(String nome) {
		return repository.findByNomeContainingIgnoreCase(nome);
	}
	
	public String insert(Aluno aluno) {
		repository.save(aluno);
		return "Registro inserido com sucesso";
	}
	
	public String update(int id, Aluno aluno) {
		Aluno tmp = repository.findById(id).get();
		aluno.setId(tmp.getId());
		
		repository.save(aluno);
		return "Registro atualizado com sucesso";
	}
	
	public String delete(int id) {
		Aluno tmp = repository.findById(id).get();
		repository.delete(tmp);
		return "Registro excluído com sucesso";
	}
	
	public String associarDisciplina(int idAluno, int idDisciplina) {
		System.out.println(idAluno + " - " + idDisciplina);
		return "";
	}
	
	public String desassociarDisciplina(int idAluno, int idDisciplina) {
		System.out.println(idAluno + " - " + idDisciplina);
		return "Disciplina Desassociada com Sucesso " + idAluno + " - " + idDisciplina;
	}
}





