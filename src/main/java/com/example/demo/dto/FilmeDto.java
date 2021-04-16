package com.example.demo.dto;

import com.example.demo.model.Filme;

public class FilmeDto {
	
	
	private String name;
	private String email;
	private Double salary;
	
	public FilmeDto() {
		// TODO Auto-generated constructor stub
	}

	public FilmeDto(String name, String email, Double salary) {
		
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	
public FilmeDto(Filme filme) {
		
		this.name = filme.getName();
		this.email = filme.getEmail();
		this.salary = filme.getSalary();
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	


}
