package com.loteria.projeto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loteria.projeto.api.model.Numero;

public interface NumeroRepository extends JpaRepository<Numero, Long>{

}
