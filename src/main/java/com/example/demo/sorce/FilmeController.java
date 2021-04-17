package com.example.demo.sorce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FilmeDtoNameEmail;
import com.example.demo.model.Filme;
import com.example.demo.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

	@Autowired
	FilmeService filmeService;

	@GetMapping("/{id}")
	public ResponseEntity<FilmeDtoNameEmail> getFilme(@PathVariable Long id) {
		FilmeDtoNameEmail filme = filmeService.getFilmeOne(id);
		if (id < 0) {
			return ResponseEntity.badRequest().build();
		}

		if (filme == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(filme);
	}

	@GetMapping("/buscar-por-nome")
	public ResponseEntity<FilmeDtoNameEmail> getFilmeName(@RequestParam String nome) {
		FilmeDtoNameEmail filme = filmeService.buscarPeloNome(nome);

		if (filme == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(filme);
	}

	@GetMapping("/buscar-por-nomes")
	public ResponseEntity<List<FilmeDtoNameEmail>> getFilmeNameList(@RequestParam String nome) {
		List<FilmeDtoNameEmail> filmes = filmeService.buscarListNome(nome);

		if (filmes == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(filmes);
	}
	
	@GetMapping("/buscar-por-emails")
	public ResponseEntity<List<FilmeDtoNameEmail>> findAllFilmesList(@RequestParam String email) {
		List<FilmeDtoNameEmail> filmes = filmeService.buscarListEmail(email);

		if (filmes == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(filmes);
	}
	
	@GetMapping("/buscar-por-like")
	public ResponseEntity<List<FilmeDtoNameEmail>> findAllNameLike(@RequestParam String name) {
		List<FilmeDtoNameEmail> filmes = filmeService.buscarNameLike(name);

		if (filmes == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(filmes);
	}
	


}
