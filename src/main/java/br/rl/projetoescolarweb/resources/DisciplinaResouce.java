package br.rl.projetoescolarweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.rl.projetoescolarweb.dao.DisciplinaDao;
import br.rl.projetoescolarweb.modelo.Disciplina;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaResouce {
	
	@Autowired
	DisciplinaDao disciplinaRepository;
	
	@RequestMapping(value = "carregar", method=RequestMethod.GET)
	public String carregar() {
		
		Disciplina disciplina = new Disciplina();
		
		disciplina.setNome("POO");
				
		disciplinaRepository.save(disciplina);
		
		return "ok";
	}
	
	@RequestMapping(value = "{id}/detalhes", method = RequestMethod.GET)
	public Disciplina buscar(@PathVariable("id") Long id) {
		return disciplinaRepository.getOne(id);
	}
	
	@RequestMapping(value = "listar/todas", method=RequestMethod.GET)
	
	public List<Disciplina> listar(){
		
		return disciplinaRepository.findAll();
	}
	
	@RequestMapping(value = "pesquisar", method = RequestMethod.GET)
	
	public List<Disciplina> pesquisar(
			
		@RequestParam(name = "nome", defaultValue = "ALL")String nome){
		
		return disciplinaRepository.findByNome(nome);
	}
}
