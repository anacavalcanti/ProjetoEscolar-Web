package br.rl.projetoescolarweb;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.rl.projetoescolarweb.dao.AlunoDao;
import br.rl.projetoescolarweb.dao.BoletimDao;
import br.rl.projetoescolarweb.dao.CursoDao;
import br.rl.projetoescolarweb.dao.DisciplinaDao;
import br.rl.projetoescolarweb.dao.EscolaDao;
import br.rl.projetoescolarweb.dao.NotaDao;
import br.rl.projetoescolarweb.dao.ProfessorDao;
import br.rl.projetoescolarweb.modelo.Aluno;
import br.rl.projetoescolarweb.modelo.Boletim;
import br.rl.projetoescolarweb.modelo.Curso;
import br.rl.projetoescolarweb.modelo.Disciplina;
import br.rl.projetoescolarweb.modelo.Endereco;
import br.rl.projetoescolarweb.modelo.Escola;
import br.rl.projetoescolarweb.modelo.Nota;
import br.rl.projetoescolarweb.modelo.Professor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetoescolarWebApplicationTests {
	
	@Autowired
	private CursoDao cursoRepository;
	
	@Autowired
	private EscolaDao escolaRepository;
	
	@Autowired
	private AlunoDao alunoRepository;
	
	@Autowired
	private ProfessorDao professorRepository;
	
	@Autowired
	private NotaDao notaRepository;
	
	@Autowired
	private DisciplinaDao disciplinaRepository;
	
	@Autowired
	private BoletimDao boletimRepository;

	@Test
	public void testAluno() {
		
		Aluno pedro = new Aluno();
		pedro.setNome("Pedro");
		pedro.setMatricula("222");
		pedro.setEndereco(new Endereco("Rua do Angar", 'D', 02,"Tabuleiro", "Maceió", "Alagoas","57075-000"));
		pedro.getTelefones().add("(82)9.9925-9987");
		pedro.getTelefones().add("(82)9.8823-2514");
		
		Aluno ana = new Aluno();
		ana.setNome("Ana");
		ana.setMatricula("125");
		ana.setEndereco(new Endereco("Rua das Flores", 'D', 521,"Centro", "Maceió", "Alagoas","57015-200"));
		ana.getTelefones().add("(82)9.8135-9987");
		ana.getTelefones().add("(82)9.9273-2514");
	}
	
	@Test
	public void testProfessor() {
		
		Professor professor = new Professor();
		professor.setNome("Luíz Cláudio");
		professor.setCpf("111.111.111-11");
		professor.setFormacao("Analista de Sistemas");	
		
		Professor professora = new Professor();
		professora.setNome("Priscylla");
		professora.setCpf("123.456.789-10");
		professora.setFormacao("Ciências da Computação");
	}
	
	@Test
	@Transactional
	public void testDiciplina() {
				
		Disciplina piu = new Disciplina();
		piu .setNome("PIU");
		
		Disciplina qls = new Disciplina();
		qls.setNome("QLS");
		
		
		Disciplina d = disciplinaRepository.getOne(1L);
		
		Disciplina d1 = disciplinaRepository.getOne(2L);
		
		Aluno a = alunoRepository.getOne(1L);
		
		Aluno a1 = alunoRepository.getOne(2L);
		
		Professor p = professorRepository.getOne(1L);
		
		Professor p1 = professorRepository.getOne(2L);
			
		d.getProfessores().add(p);
		d.getProfessores().add(p1);
		d.getAlunos().add(a);
		d1.getAlunos().add(a1);

	}
		
	@Test
	@Transactional
	public void testCurso() {
			
		Curso informatica = new Curso();
		informatica.setNome("Informática básica");
			
		Curso web= new Curso();
		web.setNome("Programação Web");
		
		
		Curso c = cursoRepository.getOne(1L);
		
		Disciplina d = disciplinaRepository.getOne(1L);
		
		Aluno a = alunoRepository.getOne(1L);
			
			
		c.getDisciplinas().add(d);
		c.getAlunos().add(a);

	}
	
	@Test
	@Transactional
	public void testEscola() {
			
		Escola ifRl = new Escola();
		ifRl.setNome("IFAL -Rio Largo");
			
		Escola ifMCZ = new Escola();
		ifMCZ.setNome("IFAL - Maceió");
		
		
		Escola escola = escolaRepository.getOne(1L);
		
		Curso c = cursoRepository.getOne(1L);
		
		Professor p = professorRepository.getOne(1L);
		
		Professor p1 = professorRepository.getOne(2L);
			
			
		escola.getCurso().add(c);
		escola.getProfessores().add(p);
		escola.getProfessores().add(p1);

	}
	
	@Test
	@Transactional
	public void testNota() {
			
		Nota nota = new Nota();
		Aluno a = alunoRepository.getOne(1L);
		nota.setAluno(a);
		Disciplina d = disciplinaRepository.getOne(1L);
		nota.setDisciplina(d);
		nota.setValor(8.5);
		
		Nota nota1 = new Nota();
		Aluno a1 = alunoRepository.getOne(2L);	
		nota1.setAluno(a1);
		Disciplina d1 = disciplinaRepository.getOne(2L);
		nota1.setDisciplina(d1);
		nota1.setValor(9.5);
		
	}
	
	@Test
	@Transactional
	public void testBoletim() {
			
		Boletim boletim = new Boletim();
		Aluno a = alunoRepository.getOne(1L);
		Nota n = notaRepository.getOne(1L);
		boletim.getNotas().add(n);
		
		Boletim boletim1 = new Boletim();
		Aluno a1 = alunoRepository.getOne(2L);	
		Nota n1 = notaRepository.getOne(2L);
		boletim.getNotas().add(n1); 
	}
	
}
