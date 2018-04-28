package br.rl.projetoescolarweb.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.rl.projetoescolarweb.modelo.Professor;

public interface ProfessorDao extends JpaRepository<Professor,Long>{
	
	public List<Professor> findByNome(String nome);

}
