package br.rl.projetoescolarweb.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "escola")
public class Escola {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 100, unique = true, name = "nome_escola", nullable = false)
	private String nome;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="escola_curso",
	joinColumns = {
			@JoinColumn(name = "id_escola", referencedColumnName = "id")},
	inverseJoinColumns = {
			@JoinColumn(name = "id_curso", referencedColumnName = "id")})
	private Set<Curso> cursos = new HashSet<>();;
	 
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name ="nome_escola")
	private Set<Professor> professores = new HashSet<>();;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "nome_escola")
	private Set<Aluno> alunos = new HashSet<>();
	
	public Escola() {
		super();
	}
	
	public Escola(String nome, Set<Curso> cursos, Set<Professor> professores, Set<Aluno> alunos) {
		super();
		this.nome = nome;
		this.cursos = cursos;
		this.professores = professores;
		this.alunos = alunos;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public Set<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<Professor> professores) {
		this.professores = professores;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public boolean adicionarAluno(Aluno aluno) {
		if(alunos.contains(aluno)) {
			return false;
		}else {
			alunos.add(aluno);
			return true;
		}
	}
	
	public boolean removerAluno(Aluno aluno) {
		if(alunos.contains(aluno)) {
			alunos.remove(aluno);
			return true;
		}else {
			return false;
		}		
	}

	public boolean adicionarProfessor(Professor professor) {
		if(professores.contains(professor)) {
			return false;
		}else {
			professores.add(professor);
			return true;
		}
	}
	
	public boolean removerProfessor(Professor professor) {
		if(professores.contains(professor)) {
			professores.remove(professor);
			return true;
		}else {
			return false;
		}		
	}

	public boolean adicionarCurso(Curso curso) {
		if(cursos.contains(curso)) {
			return false;
		}else {
			cursos.add(curso);
			return true;
		}
	}
	
	public boolean removerCurso(Curso curso) {
		if(cursos.contains(curso)) {
			cursos.remove(curso);
			return true;
		}else {
			return false;
		}
	}
}
	
	


