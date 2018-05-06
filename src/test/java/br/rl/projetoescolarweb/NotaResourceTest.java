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
import br.rl.projetoescolarweb.dao.AlunoDao;
import br.rl.projetoescolarweb.dao.DisciplinaDao;
import br.rl.projetoescolarweb.dao.NotaDao;
import br.rl.projetoescolarweb.modelo.Aluno;
import br.rl.projetoescolarweb.modelo.Disciplina;
import br.rl.projetoescolarweb.modelo.Nota;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class NotaResourceTest {

	final String BASE_PATH = "http://localhost:8080/api/nota";
	
	@Autowired
	private NotaDao notaRepository;
	@Autowired
	private DisciplinaDao disciplinaRepository;
	@Autowired
	private AlunoDao alunoRepository;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	
	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		notaRepository.deleteAll();
		
		Disciplina disciplina = disciplinaRepository.getOne(7L);
		Aluno aluno = alunoRepository.getOne(16L);
		notaRepository.save(new Nota(1L,aluno, disciplina, 10.0));
		
		Disciplina disciplina1 = disciplinaRepository.getOne(8L);
		Aluno aluno1 = alunoRepository.getOne(17L);
		notaRepository.save(new Nota(2L,aluno1, disciplina1, 6.5));
		
		Disciplina disciplina2 = disciplinaRepository.getOne(9L);
		Aluno aluno2 = alunoRepository.getOne(18L);
		notaRepository.save(new Nota(3L, aluno2, disciplina2, 5.0));
	}

	@Test
	public void deveFuncionarAListagemDeTodasAsNotas() throws JsonParseException, JsonMappingException, IOException {
		String response = restTemplate.getForObject(BASE_PATH + "/listar/todas",String.class);
		
		List<Nota>  notas = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Nota.class));
		
		int tamanhoEsperadoDaLista = 3;
		
		assertEquals(tamanhoEsperadoDaLista,notas.size());
	}

}
