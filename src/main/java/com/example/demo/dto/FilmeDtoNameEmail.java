package com.example.demo.dto;

import com.example.demo.model.Filme;

public class FilmeDtoNameEmail{

	private String name;
	private String email;;

	public FilmeDtoNameEmail() {
		// TODO Auto-generated constructor stub
	}

	public FilmeDtoNameEmail(String name, String email) {

		this.name = name;
		this.email = email;

	}

	public FilmeDtoNameEmail(Filme filme) {

		this.name = filme.getName();
		this.email = filme.getEmail();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
