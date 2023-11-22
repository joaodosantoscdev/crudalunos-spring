package br.edu.mouralacerda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.mouralacerda.domain.AlunoDisciplina;
import br.edu.mouralacerda.repository.AlunoDisciplinaRepository;

@Service
public class AlunoDisciplinaService {

	@Autowired
	private AlunoDisciplinaRepository repository;

	public List<AlunoDisciplina> selectAll(){
		return repository.findAll();
	}

	public AlunoDisciplina selectById(int id) {
		AlunoDisciplina ad = repository.findById(id).get();
		
		return ad;
	}

	public String insert(AlunoDisciplina ad) {
		repository.save(ad);
		return "Registro inserido com sucesso";
	}

	public String update(int id, AlunoDisciplina ad) {
		AlunoDisciplina tmp = repository.findById(id).get();
		ad.setId(tmp.getId());
		
		repository.save(ad);
		return "Registro atualizado com sucesso";
	}

	public String delete(int id) {
		AlunoDisciplina tmp = repository.findById(id).get();
		repository.delete(tmp);
		return "Registro excluído com sucesso";
	}
}