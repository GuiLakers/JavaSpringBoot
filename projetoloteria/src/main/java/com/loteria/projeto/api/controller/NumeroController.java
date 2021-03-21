package com.loteria.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loteria.projeto.api.model.Numero;
import com.loteria.projeto.api.service.NumeroService;

@Controller
@RequestMapping("/numeros")
public class NumeroController {

	@Autowired
	private NumeroService numeroService;
	
	@GetMapping("/mostrandoNumeros")
	public ResponseEntity<List<Numero>> mostrandoNumeros() {
		
		List<Numero> numeros = numeroService.mostrandoNumeros();
		
		return ResponseEntity.ok(numeros);
	}
}
