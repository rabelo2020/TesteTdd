package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BookingModel;

@Repository
public interface BookingModelRepository extends JpaRepository<BookingModel, String> {

	Optional<BookingModel> findByReserveName(String name);
}
