package com.example.demo;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.BookingModel;
import com.example.demo.repository.BookingModelRepository;
import com.example.demo.service.BookingService;

@SpringBootTest
class TesteTddApplicationTests {


	@Autowired
	BookingService bookingService;
	
	@MockBean
	BookingModelRepository bookingModelRepository;
	
	
	@Test
	void bookingTestServiceDayCalcular() {
		String name = "Adielmo";
		int days = bookingService.daysCalcularNewDataBase(name);
		
		Assertions.assertEquals(days, 19);
	}
	
   @BeforeEach
	public void setup() {
		 var dateIn = LocalDate.parse("2020-11-10");
		 var dateOut = LocalDate.parse("2020-11-29");
		
		BookingModel bookingModel = new BookingModel("1", "Adielmo", dateIn, dateOut, 3);
		
		Mockito.when(bookingModelRepository.findByReserveName(bookingModel.getReserveName()))
		            .thenReturn(Optional.of(bookingModel));
		
	}

}
