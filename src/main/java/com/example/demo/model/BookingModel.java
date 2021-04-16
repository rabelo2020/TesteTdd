package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class BookingModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String reserveName;
	private LocalDate ckeckIn;
	private LocalDate ckeckOut;
	private int numberGuests;
	
	public BookingModel() {
		// TODO Auto-generated constructor stub
	}
	
	

	public BookingModel(String id, String reserveName, LocalDate ckeckIn, LocalDate ckeckOut, int numberGuests) {
		
		this.id = id;
		this.reserveName = reserveName;
		this.ckeckIn = ckeckIn;
		this.ckeckOut = ckeckOut;
		this.numberGuests = numberGuests;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReserveName() {
		return reserveName;
	}

	public void setReserveName(String reserveName) {
		this.reserveName = reserveName;
	}

	public LocalDate getCkeckIn() {
		return ckeckIn;
	}

	public void setCkeckIn(LocalDate ckeckIn) {
		this.ckeckIn = ckeckIn;
	}

	public LocalDate getCkeckOut() {
		return ckeckOut;
	}

	public void setCkeckOut(LocalDate ckeckOut) {
		this.ckeckOut = ckeckOut;
	}

	public int getNumberGuests() {
		return numberGuests;
	}

	public void setNumberGuests(int numberGuests) {
		this.numberGuests = numberGuests;
	}



	@Override
	public String toString() {
		return "BookingModel [id=" + id + ", reserveName=" + reserveName + ", ckeckIn=" + ckeckIn + ", ckeckOut="
				+ ckeckOut + ", numberGuests=" + numberGuests + "]";
	}
	
	
	

}
