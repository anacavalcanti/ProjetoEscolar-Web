package br.rl.projetoescolarweb;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.rl.projetoescolarweb.dao.AlunoDao;
import br.rl.projetoescolarweb.dao.AssuntoDao;
import br.rl.projetoescolarweb.dao.BoletimDao;
import br.rl.projetoescolarweb.dao.CursoDao;
import br.rl.projetoescolarweb.dao.DisciplinaDao;
import br.rl.projetoescolarweb.dao.EscolaDao;
import br.rl.projetoescolarweb.dao.NotaDao;
import br.rl.projetoescolarweb.dao.ProfessorDao;
import br.rl.projetoescolarweb.modelo.Aluno;
import br.rl.projetoescolarweb.modelo.Assunto;
import br.rl.projetoescolarweb.modelo.Boletim;
import br.rl.projetoescolarweb.modelo.Curso;
import br.rl.projetoescolarweb.modelo.Disciplina;
import br.rl.projetoescolarweb.modelo.Endereco;
import br.rl.projetoescolarweb.modelo.Escola;
import br.rl.projetoescolarweb.modelo.Nota;
import br.rl.projetoescolarweb.modelo.Professor;
import br.rl.projetoescolarweb.modelo.TipoProfessor;

import org.springframework.transaction.annotation.Transactional;

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
	private AssuntoDao assuntoRepository;
	
	@Autowired
	private BoletimDao boletimRepository;

	@Test
	@Transactional
	public void insertAlunoTest() {
		
		Aluno aluno = new Aluno();
		aluno .setNome("Pedro");
		aluno .setMatricula("222");
		aluno .setEndereco(new Endereco("Rua do Angar", 'D', 02,"Tabuleiro", "Maceió", "Alagoas","57075-000"));
		aluno .getTelefones().add("(82)9.9925-9987");
		aluno .getTelefones().add("(82)9.8823-2514");
		
		alunoRepository.save(aluno);
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Ana");
		aluno1.setMatricula("123");
		aluno1.setEndereco(new Endereco("Rua Antônio", 'C', 05,"Centro", "Maceió", "Alagoas","57000-000"));
		aluno1.getTelefones().add("(82)9.9821-6987");
		aluno1.getTelefones().add("(82)9.9623-2214");
		
		alunoRepository.save(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Júlia");
		aluno2.setMatricula("425");
		aluno2.setEndereco(new Endereco("Rua das Flores", 'C', 258,"Farol", "Maceió", "Alagoas","570100-000"));
		aluno2.getTelefones().add("(82)9.9785-6987");
		aluno2.getTelefones().add("(82)9.9254-2814");
		
		alunoRepository.save(aluno2);
	}
	
	@Test
	@Transactional
	public void insertProfessorTest() {
		
		Professor professor = new Professor();
		professor.setNome("Luíz");
		professor.setCpf("111.111.111-11");
		professor.setFormacao("Analista de Sistemas");
		professor.setTipoprofessor(TipoProfessor.SUBSTITUTO);
		
		professorRepository.save(professor);
		
		Professor professor1 = new Professor();
		professor1.setNome("Priscylla");
		professor1.setCpf("222.222.222-22");
		professor1.setFormacao("Ciências da Computação");
		professor1.setTipoprofessor(TipoProfessor.EFETIVO);
		
		professorRepository.save(professor1);
		
		Professor professor2 = new Professor();
		professor2.setNome("Leonardo");
		professor2.setCpf("333.333.333-33");
		professor2.setFormacao("Engenharia Elétrica");
		professor2.setTipoprofessor(TipoProfessor.EFETIVO);
		
		professorRepository.save(professor2);
	}
	
	@Test
	@Transactional
	public void insertAssuntoTest() {
		Assunto assunto = new Assunto();
		assunto.setNome("Experiência do usuário");
		assuntoRepository.save(assunto);
		
		Assunto assunto1 = new Assunto();
		assunto1.setNome("Técninas de qualidade de software");
		assuntoRepository.save(assunto1);
		
		Assunto assunto2 = new Assunto();
		assunto2.setNome("Internet das coisas");
		assuntoRepository.save(assunto2);
	}
	
	@Test
	@Transactional
	public void insertDisciplinaTest() {
		
		Professor professor = professorRepository.getOne(1L);
		
		Aluno aluno = alunoRepository.getOne(7L);
		
		Assunto assunto = assuntoRepository.findAll().get(0);
		
		Disciplina disciplina = new Disciplina();
		disciplina.setNome("PIU");
		disciplina.getAssuntos().add(assunto);
		disciplina.getProfessores().add(professor);
		disciplina.getAlunos().add(aluno);
		
		disciplinaRepository.saveAndFlush(disciplina);
		
		
		
		
		Professor professor1 = professorRepository.getOne(2L);
		
		Aluno aluno1 = alunoRepository.getOne(8L);
		
		Assunto assunto1 = assuntoRepository.getOne(5L);
		
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("GQS");
		disciplina1.getAssuntos().add(assunto1);
		disciplina1.getProfessores().add(professor1);
		disciplina1.getAlunos().add(aluno1);
		
		disciplinaRepository.saveAndFlush(disciplina1);
	}
	
}
