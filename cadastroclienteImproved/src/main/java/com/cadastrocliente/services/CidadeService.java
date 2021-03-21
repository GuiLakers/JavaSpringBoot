package com.cadastrocliente.services;

import com.cadastrocliente.models.Cidade;
import com.cadastrocliente.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade cadastraCidade(Cidade cidade) {

        return cidadeRepository.save(cidade);
    }

    public Cidade encontraCidadePeloNome(String nome) {

        return cidadeRepository.findByNome(nome);
    }

    public Cidade encontraCidadePeloEstado(String estado) {

        return cidadeRepository.findByEstado(estado);
    }

}
