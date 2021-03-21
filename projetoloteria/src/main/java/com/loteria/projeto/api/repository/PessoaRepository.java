package com.loteria.projeto.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loteria.projeto.api.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	public Optional<Pessoa> findById(Long id);
	
	public Optional<Pessoa> findByEmail(String email);

}
