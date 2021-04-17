package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Query("from Filme obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
	Page<Filme> buscarFilmePages(Double minSalary, Double maxSalary, Pageable page);
	//Page<Filme> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable page);

	@Query("from Filme f WHERE LOWER(f.name) LIKE LOWER(concat('%', :name, '%'))")
	Page<Filme> buscarNamePages(String name, Pageable page);
	Page<Filme> findByNameContainingIgnoreCase(String name, Pageable page);

	
}
