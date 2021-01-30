package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Jogo;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.JogoRepository;
import com.example.demo.repository.PessoaRepository;

@Service
public class JogoService {
	@Autowired
	PessoaRepository crudPessoa;

	@Autowired
	JogoRepository crudJogo;

	@Autowired
	GerarJogosService gjogo;

	public String criarJogo(Pessoa pessoa) {

		Jogo jgNumeros = new Jogo();

		if (crudPessoa.findByEmail(pessoa.getEmail()).isPresent()) {

			jgNumeros.setJogo(gjogo.gerarJogo().toString());
			Pessoa ps = crudPessoa.findByEmail(pessoa.getEmail()).get();
			jgNumeros.setPessoa(ps);
			crudJogo.save(jgNumeros);
			return "ok";
		} else {

			crudPessoa.save(pessoa);
			Pessoa isPessoa = crudPessoa.findByEmail(pessoa.getEmail()).get();
			jgNumeros.setPessoa(isPessoa);
			jgNumeros.setJogo(gjogo.gerarJogo().toString());
			crudJogo.save(jgNumeros);
			return "ok2";
		}
	}

	public List<String> retornaJogos(Pessoa pessoa) {
		if (crudPessoa.findByEmail(pessoa.getEmail()).isPresent()) {
			
			Pessoa ps = crudPessoa.findByEmail(pessoa.getEmail()).get();
			return crudJogo.findAllByPessoa(ps);
		}else {
			return null;
		}
	}
}
