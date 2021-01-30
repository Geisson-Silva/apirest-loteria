package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Jogo;
import com.example.demo.model.Pessoa;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
	@Query("SELECT u.id, u.jogo  FROM Jogo u WHERE u.pessoa = :pessoa ORDER BY u.id ASC")
	List<String>  findAllByPessoa(@Param("pessoa") Pessoa ps);
}
