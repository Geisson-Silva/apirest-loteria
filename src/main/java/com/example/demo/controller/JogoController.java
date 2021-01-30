package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.service.JogoService;

@RestController
@RequestMapping("/")

public class JogoController {
	
	@Autowired
	JogoService jservice;
	
	@PostMapping("/geradordejogos")
	public String crjogo (@RequestBody @Valid Pessoa em) {
		return jservice.criarJogo(em);
		
	} 	
	
	@GetMapping("/encontrarjogos")
	public List<String> retornaJogo(@RequestBody Pessoa ps) {
		return jservice.retornaJogos(ps);
	
	}
	

}
