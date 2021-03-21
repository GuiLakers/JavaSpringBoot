package com.loteria.projeto.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loteria.projeto.api.model.Numero;
import com.loteria.projeto.api.model.Pessoa;
import com.loteria.projeto.api.repository.NumeroRepository;
import com.loteria.projeto.api.repository.PessoaRepository;
import com.loteria.projeto.api.service.exception.EmailJaExistenteException;
import com.loteria.projeto.api.service.exception.NumeroExistenteException;
import com.loteria.projeto.api.service.exception.PessoaInexistenteException;
import com.loteria.projeto.api.service.util.GeradorDeNumeros;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private NumeroRepository numeroRepository;
	
	@Autowired
	private GeradorDeNumeros geradorDeNumeros;
	
	public Pessoa cadastraPessoa(Pessoa pessoa) {
		
		String emailPessoa = pessoa.getEmail();
		boolean existeEmailPessoa = verificarExistenciaDeEmail(emailPessoa);
		
		if (existeEmailPessoa) {
			throw new EmailJaExistenteException();
		}
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);

		return pessoaSalva;
	}

	public Pessoa mostraPessoa(Long id) {
		
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		
		return pessoa.get();
	}

	public List<Numero> consultandoApostas(String email) {
		
		Optional<Pessoa> pessoaSalva = pessoaRepository.findByEmail(email);
		
        if (pessoaSalva.isEmpty()) {
			throw new PessoaInexistenteException();
		}

		List<Numero> numeros = buscarApostas(pessoaSalva.get());
		
		return numeros;
	}
	
	public Numero pessoaApostando(String email) {

        Optional<Pessoa> pessoaSalva = pessoaRepository.findByEmail(email);
        Pessoa pessoa = pessoaSalva.get();
        List<Numero> numerosSalvos = new ArrayList();

        numerosSalvos = buscarApostas(pessoa);
        
        boolean existeNumero = false;
        List<Integer> numeroGerado = geradorDeNumeros.gerarNumeros();
        
        if (!numerosSalvos.isEmpty()) {
        	existeNumero = numerosSalvos.contains(numeroGerado);
		}
        
        if (existeNumero) {
			throw new NumeroExistenteException();
		}
        
        String numeroString = numeroGerado.toString();
        
        Integer tamanhoOrdem = pessoaSalva.get().getNumeros().size();
        Long ordem = tamanhoOrdem.longValue();
        ordem++;
        
        Numero numero = new Numero();
        numero.setNumero(numeroString);
        numero.setOrdem(ordem);
        numero.setPessoa(pessoa);
        numeroRepository.save(numero);
  
        numerosSalvos.add(numero);

        pessoa.setNumeros(numerosSalvos);
        pessoaRepository.save(pessoa);
        numero.setPessoa(pessoa);
        
        return numero;
    }

	private List<Numero> buscarApostas(Pessoa pessoa) {
		
		List<Numero> numeros = new  ArrayList<>();
		
		numeros	= pessoa.getNumeros();
		
		return numeros;
	}
	
	private boolean verificarExistenciaDeEmail(String email) {
		
		Optional<Pessoa> pessoaSalva = pessoaRepository.findByEmail(email);
		
		if (pessoaSalva.isEmpty()) {
			return false;
		}
		return true;
	}

}
