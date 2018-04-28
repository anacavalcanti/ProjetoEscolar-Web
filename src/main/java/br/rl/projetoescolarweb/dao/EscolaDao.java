package br.rl.projetoescolarweb.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.rl.projetoescolarweb.modelo.Escola;

public interface EscolaDao extends JpaRepository<Escola,Long>{

	public List<Escola> findByNome(String nome);

}
