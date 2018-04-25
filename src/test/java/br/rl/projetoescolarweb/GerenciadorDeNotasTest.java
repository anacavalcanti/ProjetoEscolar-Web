package br.rl.projetoescolarweb;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.rl.projetoescolarweb.modelo.Aluno;
import br.rl.projetoescolarweb.modelo.Disciplina;
import br.rl.projetoescolarweb.modelo.Nota;
import br.rl.projetoescolarweb.modelo.Professor;
import br.rl.projetoescolarweb.modelo.TipoProfessor;
import br.rl.projetoescolarweb.modelo.Endereco;
import br.rl.projetoescolarweb.servico.GerenciadorDeNotas;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GerenciadorDeNotasTest {
	
	private Aluno elaine;
	private Disciplina disciplina;
	private Professor professor;
	private Nota nota;
	private GerenciadorDeNotas gerenciador;
	private boolean resultado, resultadoEsperado;
	
	@Before
	public void CriacaoDasClassesParaOsTestes() {
		this.disciplina = new Disciplina();
		this.professor = new Professor();
		this.elaine = new Aluno();
		this.nota = new Nota();
		this.gerenciador = new GerenciadorDeNotas();
		
		
		disciplina.setId(1L);
		disciplina.setNome("PQS");
		professor.setId(1L);
		professor.setNome("Priscylla");
		professor.setCpf("111.111.111-11");
		professor.setFormacao("Ciências da Computação");
		professor.setTipoprofessor(TipoProfessor.EFETIVO);
		
		
		elaine.setId(1L);
		elaine.setMatricula("2018-2");
		elaine.setNome("Elaine");
		elaine.setEndereco(new Endereco("Loteamento Bosque do Sossego", 'D', 8,"Santos Dumont", "Maceió", "Alagoas","57075-793"));
		elaine.getTelefones().add("(82)98706-7383");
		
		
		nota.setId(1L);
		nota.setAluno(elaine);
		nota.setDisciplina(disciplina);
		nota.setValor(10);
		
	}
	
	@Test
	public void deveFuncionarParaNotasMenoresQueZero() {
		
		nota.setValor(-2);
		
		resultado = gerenciador.setarNota(nota);
		
		resultadoEsperado = false;
		
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void deveFuncionarParaNotasMaioresQueDez() {
		
		nota.setValor(11);

		resultado = gerenciador.setarNota(nota);
		
		resultadoEsperado = false;
		
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void deveFuncionarParaNotasSemAluno() {
		
		nota.setAluno(null);
		
		resultado = gerenciador.setarNota(nota);
		
		resultadoEsperado = false;
		
		assertEquals(resultadoEsperado, resultado);	
	}
	
	@Test
	public void deveFuncionarParaNotasSemDisciplina() {
		
		nota.setDisciplina(null);
		
		resultado = gerenciador.setarNota(nota);
		
		resultadoEsperado = false;
		
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void deveFuncionarParaNotasSemDisciplinaEaluno() {
		
		nota.setAluno(null);
		nota.setDisciplina(null);
		
		resultado = gerenciador.setarNota(nota);
		
		resultadoEsperado = false;
		
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void deveFuncionarParaNotaDez() {
		
		resultado = gerenciador.setarNota(nota);
		
		resultadoEsperado = true;
		
		assertEquals(resultadoEsperado, resultado);
		
	}
	
	@Test
	public void deveFuncionarParaNotaEntreZeroEDez() {
		
		nota.setValor(7.5);
		
		resultado = gerenciador.setarNota(nota);
		
		resultadoEsperado = true;
		
		assertEquals(resultadoEsperado, resultado);
		
	}
	
	@Test
	public void deveFuncionarParaNotaZero() {
		
		nota.setValor(0.0);
		
		resultado = gerenciador.setarNota(nota);
		
		resultadoEsperado = true;
		
		assertEquals(resultadoEsperado, resultado);
		
	}
}