package br.rl.projetoescolarweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.rl.projetoescolarweb.modelo.Boletim;

public interface BoletimDao extends JpaRepository<Boletim,Long>{

}
