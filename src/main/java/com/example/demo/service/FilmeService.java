package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FilmeDto;
import com.example.demo.dto.FilmeDtoNameEmail;
import com.example.demo.model.Filme;
import com.example.demo.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	FilmeRepository filmeRepository;

	public FilmeDtoNameEmail getFilmeOne(Long id) {
		Optional<Filme> filmeOptional = filmeRepository.findById(id);
		if (filmeOptional.isEmpty()) {
			// throw new FilmeIdNaoEncotradoException(String.format("Filme do código %f não
			// existe!", id));
			return null;
		}

		return new FilmeDtoNameEmail(filmeOptional.get());

	}

	public FilmeDtoNameEmail buscarPeloNome(String nome) {
		Optional<Filme> filmeName = filmeRepository.findFirstByNameContaining(nome);
		if (filmeName.isEmpty()) {
			return null;
		}
		return new FilmeDtoNameEmail(filmeName.get());
	}

	public List<FilmeDtoNameEmail> buscarListNome(String name) {
		List<Filme> listNames = filmeRepository.findByNameIgnoreCase(name);
		if (listNames.isEmpty()) {
			return null;
		}

		return listNames.stream().map(x -> new FilmeDtoNameEmail(x)).collect(Collectors.toList());

	}

	public List<FilmeDtoNameEmail> buscarListEmail(String email) {
		List<Filme> listNames = filmeRepository.findByEmailContaining(email);
		if (listNames.isEmpty()) {
			return null;
		}

		return listNames.stream().map(x -> new FilmeDtoNameEmail(x)).collect(Collectors.toList());

	}
	
	public List<FilmeDtoNameEmail> buscarNameLike(String name) {
		//List<Filme> listNames = filmeRepository.findByNameContainingIgnoreCase(name);
		List<Filme> listNames = filmeRepository.buscarPorNome(name);
		if (listNames.isEmpty()) {
			return null;
		}

		return listNames.stream().map(x -> new FilmeDtoNameEmail(x)).collect(Collectors.toList());

	}

	public Page<Filme> buscarFilmePages(Pageable page) {
		
		return filmeRepository.findAll(page);
		
  //return pageFilmes.stream().map(x -> new FilmeDto(x)).collect(null)
	}

	public Page<Filme> buscarSalary(Double minSalary, Double maxSalary, Pageable page) {
		
		return filmeRepository.buscarFilmePages(minSalary, maxSalary, page);
	}

	public Page<Filme> buscarName(String name, Pageable page) {
		
		return filmeRepository.findByNameContainingIgnoreCase(name, page);
	}

}
