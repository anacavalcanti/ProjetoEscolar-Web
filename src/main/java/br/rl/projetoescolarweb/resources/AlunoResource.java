package br.rl.projetoescolarweb.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.rl.projetoescolarweb.dao.AlunoDao;
import br.rl.projetoescolarweb.modelo.Aluno;
import br.rl.projetoescolarweb.modelo.Endereco;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {
	
	@Autowired
	AlunoDao alunoRepository;
	
	@RequestMapping(value = "carregar", method=RequestMethod.GET)
	public String carregar() {
		
		Aluno aluno = new Aluno();
		
		aluno.setNome("Maria José");
		aluno.setMatricula("1345");
		aluno.setEndereco(new Endereco("Rua Marechal", 'A', 320, "Tabuleiro", "Maceio", "AL", "57065-000"));
			
		alunoRepository.save(aluno);
		
		return "ok";
	}
	
	@RequestMapping(value = "/{id}/detalhes", 
			method = RequestMethod.GET)
	public Aluno buscar(@PathVariable("id") Long id) {
		return alunoRepository.getOne(id);
	}
	
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	
	public List<Aluno> listar(){
		return alunoRepository.findAll();
	}
	
	@RequestMapping(value = "/pesquisar", method = RequestMethod.GET)
	
	public List<Aluno> pesquisar(
			
		@RequestParam(name = "nome", defaultValue = "ALL")String nome){
		
		return alunoRepository.findByNome(nome);
	}
}
