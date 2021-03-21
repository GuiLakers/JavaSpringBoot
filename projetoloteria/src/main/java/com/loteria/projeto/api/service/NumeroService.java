package com.loteria.projeto.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loteria.projeto.api.model.Numero;
import com.loteria.projeto.api.repository.NumeroRepository;

@Service
public class NumeroService {
	
	@Autowired
	private NumeroRepository numeroRepository;

	public List<Numero> mostrandoNumeros() {

		List<Numero> numerosSalvos = numeroRepository.findAll();
		
		return numerosSalvos;
	}

}
