package br.rl.projetoescolarweb.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.rl.projetoescolarweb.dao.EscolaDao;
import br.rl.projetoescolarweb.modelo.Escola;

@RestController
@RequestMapping("/api/escola")
public class EscolaResource {

		@Autowired
		EscolaDao escolaRepository;
		
		@RequestMapping(value = "carregar", method = RequestMethod.GET)
		public String carregar() {
			Escola escola = new Escola();
			
			escola.setNome("IFAL");
					
			escolaRepository.save(escola);
			return "ok";
		}
		
		@RequestMapping(value = "{id}/detalhes", method = RequestMethod.GET)
		
		public Escola buscar(@PathVariable("id") Long id) {
			
			return escolaRepository.getOne(id);
		}
		
		@RequestMapping(value = "listar/todas", method=RequestMethod.GET)
		
		public List<Escola> listar(){
			
			return escolaRepository.findAll();
		}
		
		@RequestMapping(value = "pesquisar", method = RequestMethod.GET)
		
		public List<Escola> pesquisar(
				
			@RequestParam(name = "nome", defaultValue = "ALL")String nome){
			
			return escolaRepository.findByNome(nome);
		}
}

