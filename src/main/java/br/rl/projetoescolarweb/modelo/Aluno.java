package br.rl.projetoescolarweb.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="aluno")
public class Aluno extends Pessoa {
	
	@Column(unique = true, name = "matricula_aluno", nullable = false)
	private String matricula;
	
	@Column(length = 60, name = "nome_aluno", nullable = false)
	private String nome;
	
	@ManyToMany(mappedBy = "alunos")
	private Set<Disciplina> disciplinas = new HashSet<>();
	
	@Embedded
	private Endereco endereco;
	
	@ElementCollection
	@CollectionTable(name = "telefone_aluno",
	joinColumns = @JoinColumn(name = "id_aluno"))
	@Column(length = 20 , name = "numero_aluno", nullable = false)
	private List<String> telefones = new ArrayList<>();
	
	public Aluno() {
		super();
	}

	public Aluno(String matricula, String nome, Set<Disciplina> disciplinas, Endereco endereco,
			List<String> telefones) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.disciplinas = disciplinas;
		this.endereco = endereco;
		this.telefones = telefones;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}
}
