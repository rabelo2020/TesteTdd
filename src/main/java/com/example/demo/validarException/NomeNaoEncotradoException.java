package com.example.demo.validarException;

public class NomeNaoEncotradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NomeNaoEncotradoException(String msg) {
		super(msg);
	}

}
