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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="aluno")
public class Aluno{
	
	@Id
	@GeneratedValue
	private Long id;
	
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

	public Aluno(Long id, String matricula, String nome, Set<Disciplina> disciplinas, Endereco endereco,
			List<String> telefones) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.disciplinas = disciplinas;
		this.endereco = endereco;
		this.telefones = telefones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
