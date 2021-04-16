package com.example.demo.validarException;

public class FilmeIdNaoEncotradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FilmeIdNaoEncotradoException(String msg) {
		super(msg);
	}

}
