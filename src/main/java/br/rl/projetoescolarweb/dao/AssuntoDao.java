package br.rl.projetoescolarweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rl.projetoescolarweb.modelo.Assunto;

public interface AssuntoDao extends JpaRepository<Assunto,Long>{

}
