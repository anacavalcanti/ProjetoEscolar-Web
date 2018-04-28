package br.rl.projetoescolarweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.rl.projetoescolarweb.modelo.Nota;
public interface NotaDao extends JpaRepository<Nota,Long>{

}
