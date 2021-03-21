package com.cadastrocliente.repositories;

import com.cadastrocliente.models.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Page<Cidade> findByNome(String nome, Pageable pageable);

    Page<Cidade> findByEstado(String estado,Pageable pageable);
}
