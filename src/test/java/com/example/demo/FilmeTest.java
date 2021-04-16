package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.sorce.FilmeController;

@AutoConfigureMockMvc
@SpringBootTest
public class FilmeTest {

	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testBuscarFilmeId() throws Exception {
		Long id = 3L;
		mockMvc.perform(get("/filmes/"+id))
		       .andExpect(status().isOk());
	}
	
	@Test
	public void testFalharBuscarFilmeId() throws Exception {
		Long id = 103L;
		
		mockMvc.perform(get("/filmes/"+id))
		.andExpect(status().isNotFound());
	}

}
