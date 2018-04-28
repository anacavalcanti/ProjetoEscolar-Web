package br.rl.projetoescolarweb.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.rl.projetoescolarweb.dao.ProfessorDao;
import br.rl.projetoescolarweb.modelo.Professor;

@RestController
@RequestMapping("/professor")
public class ProfessorResouce {
	
	@Autowired
	ProfessorDao professorRepository;
	
	@RequestMapping(value = "carregar", method=RequestMethod.GET)
	
	public String carregar() {
		
		Professor professor = new Professor();
		
		professor.setNome("Walker Ataíde");
				
		professorRepository.save(professor);
		
		return "ok";
	}
	
	@RequestMapping(value = "{id}/detalhes", method = RequestMethod.GET)
	
	public Professor buscar(@PathVariable("id") Long id) {
		
		return professorRepository.getOne(id);
	}
	
	@RequestMapping(value = "listar/todos", method=RequestMethod.GET)
	
	public List<Professor> listar(){
		
		return professorRepository.findAll();
	}
	
	@RequestMapping(value = "pesquisar", method = RequestMethod.GET)
	
	public List<Professor> pesquisar(
			
		@RequestParam(name = "nome", defaultValue = "ALL")String nome){
		
		return professorRepository.findByNome(nome);
	}
}
