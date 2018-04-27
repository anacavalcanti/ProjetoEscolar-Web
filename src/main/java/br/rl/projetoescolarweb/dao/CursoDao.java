package br.rl.projetoescolarweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rl.projetoescolarweb.modelo.Curso;
import br.rl.projetoescolarweb.modelo.Escola;

public interface CursoDao extends JpaRepository<Curso,Long>{
	public List<Curso> findByNome(String nome);
}
