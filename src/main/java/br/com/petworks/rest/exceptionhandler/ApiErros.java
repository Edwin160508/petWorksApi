package br.com.petworks.rest.exceptionhandler;

public class ApiErros {
	private String mensagemUsuario;
	private String mensagemDesenvolvedor;
	
	public ApiErros(String mensagemUsuario, String mensagemDesenvolvedor) {
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}

	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}
}
