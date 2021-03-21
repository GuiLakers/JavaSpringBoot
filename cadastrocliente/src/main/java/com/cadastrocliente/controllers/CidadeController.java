package com.cadastrocliente.controllers;

import com.cadastrocliente.models.Cidade;
import com.cadastrocliente.services.CidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CidadeController.class);

    @GetMapping("/encontraCidadePorNome/{nome}")
    public Page<Cidade> encontraCidadePorNome(@PathVariable String nome, @PageableDefault(2) Pageable pageable) {

        return cidadeService.encontraCidadePeloNome(nome, pageable);
    }

    @GetMapping("/encontraCidadePorEstado/{estado}")
    public Page<Cidade> encontraCidadePorEstado(@PathVariable String estado, @PageableDefault(2) Pageable pageable) {

        return cidadeService.encontraCidadePeloEstado(estado, pageable);
    }

    @PostMapping("/cadastraCidade")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastraCidade(@RequestBody Cidade cidade) {

        cidadeService.cadastraCidade(cidade);

        return "cadastro feito com sucesso!";
    }

}
