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

@Entity
@Table (name="curso")
public class Curso {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 60, unique = true, name = "nome_curso", nullable = false)
	private String nome;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="curso_disciplina",
		joinColumns = {
			@JoinColumn(name = "id_curso", referencedColumnName = "id")},
		inverseJoinColumns = {
			@JoinColumn(name = "id_disciplina", referencedColumnName = "id")})
	private Set<Disciplina> disciplinas = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_curso")
	private Set<Aluno> alunos = new HashSet<>();

	public Curso() {
		super();
	}
	
	public Curso(Long id, String nome, Set<Disciplina> disciplinas, Set<Aluno> alunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.disciplinas = disciplinas;
		this.alunos = alunos;
	}
	
	public Curso(String nome) {
		this.nome = nome;
	}
	
	public Curso(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
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
	
	public boolean adicionarDisciplina(Disciplina disciplina) {
		if(disciplinas.contains(disciplina)) {
			return false;
		}else {
			disciplinas.add(disciplina);
			return true;
		}
	}
	
	public boolean removerDisciplina(Disciplina disciplina) {
		if(disciplinas.contains(disciplina)) {
			disciplinas.remove(disciplina);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
