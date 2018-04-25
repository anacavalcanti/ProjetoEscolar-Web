package br.rl.projetoescolarweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rl.projetoescolarweb.modelo.Disciplina;

public interface DisciplinaDao extends JpaRepository<Disciplina,Long>{

}
