package com.example.demo.service;


import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookingModel;
import com.example.demo.repository.BookingModelRepository;
import com.example.demo.validarException.NomeNaoEncotradoException;

@Service
public class BookingService {
	
	
	@Autowired 
	private BookingModelRepository bookingModelRepository;
	 

	public int daysCalcularNewDataBase(String name) {
	Optional<BookingModel> optionalBooking = bookingModelRepository.findByReserveName(name);
	
	if (optionalBooking.isEmpty()) {
		throw new NomeNaoEncotradoException(String.format("Não existe esse nome %s", name));
	}
return Period.between(optionalBooking.get().getCkeckIn(), optionalBooking.get().getCkeckOut()).getDays();
	
	}

}
