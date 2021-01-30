package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class GerarJogosService {
	public List<Integer> gerarJogo() {		
		List<Integer> numeros = new ArrayList<>();
		
		for (int i = 1; i <=60; i++) {
			numeros.add(i);
			}
		

		Collections.shuffle(numeros);
		
		List<Integer> escolhidos = numeros.subList(0, 6);
		Collections.sort(escolhidos);
		return escolhidos;
		} 

}
