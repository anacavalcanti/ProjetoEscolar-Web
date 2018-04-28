package br.rl.projetoescolarweb.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.rl.projetoescolarweb.modelo.Disciplina;

public interface DisciplinaDao extends JpaRepository<Disciplina,Long>{
	
	public List<Disciplina> findByNome(String nome);
}
