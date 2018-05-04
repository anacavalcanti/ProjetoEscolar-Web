package br.rl.projetoescolarweb.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="professor")
public class Professor{
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 14, unique = true, name = "cpf_professor")
	private String cpf;
	
	@Column(length = 60, name = "nome_professor")
	private String nome;
	
	@Column(length = 150, name = "formacao_professor")
	private String formacao;
	
	@Column()
	@Enumerated(EnumType.STRING)
	private TipoProfessor tipoprofessor = TipoProfessor.EFETIVO;
	
	public Professor() {
		super();
	}

	public Professor(Long id, String cpf, String nome, String formacao, TipoProfessor tipoprofessor) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.formacao = formacao;
		this.tipoprofessor = tipoprofessor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public TipoProfessor getTipoprofessor() {
		return tipoprofessor;
	}

	public void setTipoprofessor(TipoProfessor tipoprofessor) {
		this.tipoprofessor = tipoprofessor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
