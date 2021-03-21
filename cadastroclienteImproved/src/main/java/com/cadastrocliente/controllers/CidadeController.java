package com.cadastrocliente.controllers;

import com.cadastrocliente.models.Cidade;
import com.cadastrocliente.services.CidadeService;
import java.net.URI;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    private final Logger logger = LoggerFactory.getLogger(CidadeController.class);

    @GetMapping("/encontraPorNome/{nome}")
    public Cidade encontraCidadePorNome(@PathVariable String nome) {
        logger.trace("method encontraCidadePorNome accessed");
        return cidadeService.encontraCidadePeloNome(nome);
    }

    @GetMapping("/encontraPorEstado/{estado}")
    public Cidade encontraCidadePorEstado(@PathVariable String estado) {
        logger.trace("method encontraCidadePorEstado accessed");
        return cidadeService.encontraCidadePeloEstado(estado);
    }

      //To post in the requestbody you do not have to identify the ID of the object. It is autoincrement
    @PostMapping("/cadastra")
    public ResponseEntity<Cidade> cadastraCidade(@RequestBody @Valid Cidade cidade, UriComponentsBuilder uriBuilder) {    
        URI uri = uriBuilder.path("/cidade/{id}").buildAndExpand(cidade.getId()).toUri();
        cidadeService.cadastraCidade(cidade);
        logger.trace("method cadastraCidade accessed");
        return ResponseEntity.created(uri).body(cidade);
        //return ResponseEntity.status(HttpStatus.CREATED).body(cidade);// sem o uso do URIComponentsBuilder 
    }

    //To update in the requestbody you have to identify the ID of the object 
    @PutMapping("/atualiza")
    public ResponseEntity<Cidade> atualizaCidade(@RequestBody Cidade cidade) {
        cidadeService.cadastraCidade(cidade);
        logger.trace("method atualizaCidade accessed");
        return ResponseEntity.ok(cidade);
    }

}
