package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pessoa;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Long>{
	@Query("SELECT u FROM Pessoa u WHERE u.email = :email")
	Optional<Pessoa>  findByEmail(@Param("email") String email);
		
}
