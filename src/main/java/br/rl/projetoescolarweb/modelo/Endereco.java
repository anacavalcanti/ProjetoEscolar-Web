package br.rl.projetoescolarweb.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	
	@Column(length = 100, name = "endereco_aluno", nullable = false)
	private String nome;
	
	@Column(name = "quadra", nullable = false)
	private char quadra;
	
	@Column(name = "numero", nullable = false)
	private int numero;
	
	@Column(length = 100, name = "bairro", nullable = false)
	private String bairro;
	
	@Column(length = 20, name = "cidade", nullable = false)
	private String cidade;
	
	@Column(length = 25, name = "estado", nullable = false)
	private String estado;
	
	@Column(length = 25, name = "cep", nullable = false)
	private String cep;
	
	public Endereco() {
		super();
		
	}

	public Endereco(String nome, char quadra, int numero, String bairro, String cidade, String estado, String cep) {
		super();
		this.nome = nome;
		this.quadra = quadra;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getQuadra() {
		return quadra;
	}

	public void setQuadra(char quadra) {
		this.quadra = quadra;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
