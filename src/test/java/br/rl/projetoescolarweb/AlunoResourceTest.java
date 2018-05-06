package br.rl.projetoescolarweb;

import static org.junit.Assert.*;

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
import br.rl.projetoescolarweb.modelo.Aluno;
import br.rl.projetoescolarweb.modelo.Endereco;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AlunoResourceTest {
	
	final String BASE_PATH = "http://localhost:8080/api/aluno";
	
	@Autowired
	private AlunoDao alunoRepository;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();

	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		alunoRepository.deleteAll();
		
		Aluno pedro = new Aluno();
		pedro.setNome("Pedro");
		pedro.setMatricula("222");
		pedro.setEndereco(new Endereco("Rua do Angar", 'D', 02,"Tabuleiro", "Maceió", "Alagoas","57075-000"));
		pedro.getTelefones().add("(82)9.9925-9987");
		pedro.getTelefones().add("(82)9.8823-2514");
		
		alunoRepository.save(pedro);
		
		Aluno ana = new Aluno();
		ana.setNome("Ana");
		ana.setMatricula("123");
		ana.setEndereco(new Endereco("Rua Antônio", 'C', 05,"Centro", "Maceió", "Alagoas","57000-000"));
		ana.getTelefones().add("(82)9.9821-6987");
		ana.getTelefones().add("(82)9.9623-2214");
		
		alunoRepository.save(ana);
		
		Aluno julia = new Aluno();
		julia.setNome("Júlia");
		julia.setMatricula("425");
		julia.setEndereco(new Endereco("Rua das Flores", 'C', 258,"Farol", "Maceió", "Alagoas","570100-000"));
		julia.getTelefones().add("(82)9.9785-6987");
		julia.getTelefones().add("(82)9.9254-2814");
		
		alunoRepository.save(julia);
	}

	@Test
	public void deveFuncionarAListagemDeTodosOsAlunos() throws JsonParseException, JsonMappingException, IOException {
		String response = restTemplate.getForObject(BASE_PATH + "/listar/todos",String.class);
		
		List<Aluno>  alunos = MAPPER.readValue(response,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Aluno.class));
		
		int tamanhoEsperadoDaLista = 3;
		
		assertEquals(tamanhoEsperadoDaLista,alunos.size());
	}
}
