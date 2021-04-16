package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	Optional<Filme> findFirstByNameContaining(String name);

	//List<Filme> findByNameContaining(String nome);
	List<Filme> findByNameIgnoreCase(String name);

	List<Filme> findByEmailContaining(String email);
	
	List<Filme> findByNameContainingIgnoreCase(String name);

	@Query("from Filme u where lower(u.name) like lower(concat('%', :name,'%'))")
	public List<Filme> buscarPorNome(@Param("name") String name);
}
