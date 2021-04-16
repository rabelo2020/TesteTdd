package com.example.demo.sorce;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookingModel;

@RestController
@RequestMapping("/bookings")
public class BookingModelController {
	
	BookingModel book = new BookingModel("1", "Adielmo", LocalDate.parse("2020-01-20"), LocalDate.parse("2020-01-31"), 3);
	
	@GetMapping
	public ResponseEntity<BookingModel> getAll(){
		
		return ResponseEntity.ok().body(book);
		
	}
	
	@PostMapping
	public ResponseEntity<BookingModel> saveBooking(){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(book);
	}

}
