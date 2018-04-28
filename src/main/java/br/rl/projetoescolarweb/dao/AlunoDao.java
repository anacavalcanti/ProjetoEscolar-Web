package br.rl.projetoescolarweb.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.rl.projetoescolarweb.modelo.Aluno;

public interface AlunoDao extends JpaRepository<Aluno,Long>{
	
	public List<Aluno> findByNome(String nome);

}
