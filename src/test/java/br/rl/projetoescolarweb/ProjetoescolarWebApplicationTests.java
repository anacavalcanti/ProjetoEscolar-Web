package br.rl.projetoescolarweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.rl.projetoescolarweb.dao.CursoDao;
import br.rl.projetoescolarweb.modelo.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetoescolarWebApplicationTests {
	
	@Autowired
	private CursoDao repositorycurso;

	@Test
	public void testeCursoInsert() {
		
		Curso c = new Curso(7L,"INFORMÁTICA BÁSICA - 3");
		
		repositorycurso.save(c);
		
	}

}
