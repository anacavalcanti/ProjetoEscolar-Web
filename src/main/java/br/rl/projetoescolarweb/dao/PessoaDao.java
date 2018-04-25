package br.rl.projetoescolarweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rl.projetoescolarweb.modelo.Pessoa;

public interface PessoaDao extends JpaRepository<Pessoa,Long>{

}
