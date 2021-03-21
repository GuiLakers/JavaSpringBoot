package com.cadastrocliente.repositories;

import com.cadastrocliente.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Cidade findByNome(String nome);

    Cidade findByEstado(String estado);
}
