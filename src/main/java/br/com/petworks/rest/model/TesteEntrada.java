package br.com.petworks.rest.model;

import javax.validation.constraints.NotEmpty;

public class TesteEntrada {
	private Long id;
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;
	
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
	
	
}
