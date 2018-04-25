package br.rl.projetoescolarweb.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table (name="professor")
public class Professor extends Pessoa {
	
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

	public Professor(String cpf, String nome, String formacao, TipoProfessor tipoprofessor) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.formacao = formacao;
		this.tipoprofessor = tipoprofessor;
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
}
