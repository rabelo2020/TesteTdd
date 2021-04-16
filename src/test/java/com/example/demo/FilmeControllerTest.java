package com.example.demo;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.example.demo.dto.FilmeDtoNameEmail;
import com.example.demo.model.Filme;
import com.example.demo.service.FilmeService;
import com.example.demo.sorce.FilmeController;

import io.restassured.http.ContentType;

@WebMvcTest
public class FilmeControllerTest {
	
	@MockBean
	FilmeService filmeService;

	@Autowired
	private FilmeController filmeController;
	

	@BeforeEach
	public void setup() {
//		RestAssuredMockMvc.standaloneSetup(filmeController);
    standaloneSetup(this.filmeController);

	}


	@Test
	public void testBuscarFilmeId() throws Exception {
  //RestAssuredMockMvc.given();
when(this.filmeService.getFilmeOne(1L))
   .thenReturn(new FilmeDtoNameEmail( "Ninfetas Safadas", "Filme de muito Sexo, de mais de 2 horas"));
	
	given()
	   .accept(ContentType.JSON)
	.when()
	   .get("/filmes/{id}", 1L)
	.then()
	   .statusCode(HttpStatus.OK.value());
	
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscarFilme() {
		when(this.filmeService.getFilmeOne(152L))
		  .thenReturn(null);
		
	given()
		  .accept(ContentType.JSON)
	.when()
		 .get("/filmes/{id}", 152L)
	.then()
	     .statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void deveRetornarBadRequest_QuandoBuscarFilme() {
		given()
		    .accept(ContentType.JSON)
		.when()
		    .get("/filmes/{id}", -1L)
		.then()
		    .statusCode(HttpStatus.BAD_REQUEST.value());
		
		verify(this.filmeService, never()).getFilmeOne(0L);
		
	}

}
