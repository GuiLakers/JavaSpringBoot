package com.cadastrocliente.services;

import com.cadastrocliente.models.Cidade;
import com.cadastrocliente.repositories.CidadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;
    
   private static final Logger LOGGER = LoggerFactory.getLogger(CidadeService.class);

    public void cadastraCidade(Cidade cidade) {

        cidadeRepository.save(cidade);
    }

    public Page<Cidade> encontraCidadePeloNome(String nome, Pageable pageable) {

        return cidadeRepository.findByNome(nome, pageable);
    }

    public Page<Cidade> encontraCidadePeloEstado(String estado, Pageable pageable) {

        return cidadeRepository.findByEstado(estado, pageable);
    }

}
