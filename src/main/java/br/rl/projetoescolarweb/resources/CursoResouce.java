package br.rl.projetoescolarweb.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.rl.projetoescolarweb.dao.CursoDao;
import br.rl.projetoescolarweb.modelo.Curso;

@RestController
@RequestMapping("/curso")
public class CursoResouce {
	
	@Autowired
	CursoDao cursoRepository;
	
	@RequestMapping(value ="carregar", method=RequestMethod.GET)
	
	public String carregar() {
		
		Curso curso = new Curso();
		
		curso.setNome("Luíz");
				
		cursoRepository.save(curso);
		
		return "ok";
	}
	
	@RequestMapping(value ="{id}/detalhes", method = RequestMethod.GET)
	
	public Curso buscar(@PathVariable("id") Long id) {
		
		return cursoRepository.getOne(id);
	}
	
	@RequestMapping(value ="listar/todos", method=RequestMethod.GET)
	
	public List<Curso> listar(){
		
		return cursoRepository.findAll();
	}
	
	@RequestMapping(value = "pesquisar", method = RequestMethod.GET)
	
	public List<Curso> pesquisar(
			
		@RequestParam(name = "nome", defaultValue = "ALL")String nome){
		
		return cursoRepository.findByNome(nome);
	}

}
