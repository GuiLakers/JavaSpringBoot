package com.cadastrocliente.exceptions;

public class ErrorMessage400 {
	
	private String campo;
	private String erro;
	
	public ErrorMessage400(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	

}
