package br.rl.projetoescolarweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rl.projetoescolarweb.modelo.Curso;

public interface CursoDao extends JpaRepository<Curso,Long>{

}
