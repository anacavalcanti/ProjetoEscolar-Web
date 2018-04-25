package br.rl.projetoescolarweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rl.projetoescolarweb.modelo.Escola;

public interface EscolaDao extends JpaRepository<Escola,Long>{

}
