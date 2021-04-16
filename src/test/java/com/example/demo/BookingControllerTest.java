package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.BookingModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void testBuscarListBookings() throws Exception {
		mockMvc.perform(get("/bookings"))
		        .andExpect(status().isOk());
		        
	}
	
	@Test
	public void testSaveBooking() throws Exception {
		 var dateIn = LocalDate.parse("2020-11-10");
		 var dateOut = LocalDate.parse("2020-11-29");
		
		BookingModel bookingModel = new BookingModel("1", "Adielmo", dateIn, dateOut, 3);
		
		mockMvc.perform(post("/bookings")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(bookingModel)))
		        .andExpect(status().isCreated());
		      
		       	
		
		
	}
}
