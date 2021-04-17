package com.example.demo.sorce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Filme;
import com.example.demo.service.FilmeService;

@RestController
@RequestMapping("pages")
public class FilmeControllerPage {
	
	@Autowired
	FilmeService filmeService;
	
	@GetMapping
	public ResponseEntity<Page<Filme>> findAllPages(Pageable page){
	Page<Filme> pagina = filmeService.buscarFilmePages(page);
	
	return ResponseEntity.ok().body(pagina);
	
	}


	@GetMapping("/procurar-salary")
	public ResponseEntity<Page<Filme>> procurarSalary(@RequestParam Double minSalary,
			@RequestParam Double maxSalary, Pageable page){
	Page<Filme> pagina = filmeService.buscarSalary(minSalary, maxSalary ,page);
	
	return ResponseEntity.ok().body(pagina);
//http://localhost:8080/pages/procurar-salary?minSalary=1500&maxSalary=5500&page=0&size=2&sort=salary,asc
	}
	
	@GetMapping("/procurar-name")
	public ResponseEntity<Page<Filme>> procurarSalary(String name, Pageable page){
	Page<Filme> pagina = filmeService.buscarName(name ,page);
	
	return ResponseEntity.ok().body(pagina);
//http://localhost:8080/pages/procurar-name?name=GUSTO&page=0&size=2&sort=salary,desc	
	
	}


}
