package br.rl.projetoescolarweb;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.rl.projetoescolarweb.dao.CursoDao;
import br.rl.projetoescolarweb.modelo.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CursoResourceTest {
	
	final String BASE_PATH = "http://localhost:8080/api/curso";
	
	@Autowired
	private CursoDao cursoRepository;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();

	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		cursoRepository.deleteAll();
		
		Curso informatica  = new Curso();
		informatica.setNome("Informática básica");
		
		cursoRepository.save(informatica);
		
		Curso logica  = new Curso();
		logica.setNome("Lógica de Programação");
		
		cursoRepository.save(logica);
		
		Curso web = new Curso();
		web.setNome("Programação Web");
		
		cursoRepository.save(web);
		
	}

	@Test
	public void deveFuncionarAListagemDeTodosOsCursos() throws JsonParseException, JsonMappingException, IOException {
		String response = restTemplate.getForObject(BASE_PATH + "/listar/todos",String.class);
		
		List<Curso>  cursos = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Curso.class));
		
		int tamanhoEsperadoDaLista = 3;
		
		assertEquals(tamanhoEsperadoDaLista,cursos.size());
	}

}
