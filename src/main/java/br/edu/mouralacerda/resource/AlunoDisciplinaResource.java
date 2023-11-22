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

import br.edu.mouralacerda.domain.AlunoDisciplina;
import br.edu.mouralacerda.service.AlunoDisciplinaService;

@RestController
@CrossOrigin(origins = "*")
public class AlunoDisciplinaResource {

	@Autowired
	private AlunoDisciplinaService service;

	@GetMapping("ad")
	public List<AlunoDisciplina> getAll() {
		return service.selectAll();
	}

	@GetMapping("ad/{id}")
	public AlunoDisciplina getById(@PathVariable int id) {
		return service.selectById(id);
	}

	@PostMapping("ad")
	public String create(@RequestBody AlunoDisciplina ad) {
		return service.insert(ad);
	}

	@PutMapping("ad/{id}")
	public String update(@PathVariable int id, @RequestBody AlunoDisciplina ad) {
		return service.update(id, ad);
	}
	
	@DeleteMapping("ad/{id}")
	public String Delete(@PathVariable int id) {
		return service.delete(id);
	}
}