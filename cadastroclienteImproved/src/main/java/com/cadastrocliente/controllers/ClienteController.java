package com.cadastrocliente.controllers;

import com.cadastrocliente.models.Cliente;
import com.cadastrocliente.services.ClienteService;
import java.net.URI;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    private final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @GetMapping("/encontraPorNomeCompleto/{nomeCompleto}")
    public ResponseEntity<Cliente> encontraClientePorNomeCompleto(@PathVariable String nomeCompleto) {
        Cliente cliente = clienteService.encontraClientePorNomeCompleto(nomeCompleto);
        logger.trace("method encontraClientePorNomeCompleto accessed");
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/encontra/{id}")
    public ResponseEntity<Cliente> encontraClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.encontraClientePorId(id);
        logger.trace("method encontraClientePorNomeId accessed");
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/cadastra")
    public ResponseEntity<Cliente> cadastraCliente(@RequestBody @Valid Cliente cliente, UriComponentsBuilder uriBuilder) {

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        clienteService.cadastraCliente(cliente);
        logger.trace("method cadastraCliente accessed");
        return ResponseEntity.created(uri).body(cliente);
        //return ResponseEntity.status(HttpStatus.CREATED).body(cliente);// sem o uso do URIComponentsBuilder 
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Cliente> removeClientePorId(@PathVariable Long id) {
        clienteService.removeClientePorId(id);
        logger.trace("method removeClientePorId accessed");
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualiza")
    public ResponseEntity<Cliente> atualizaCliente(@RequestBody Cliente cliente) {
        clienteService.cadastraCliente(cliente);
        logger.trace("method atualizaCliente accessed");
        return ResponseEntity.ok(cliente);
    }

    @PatchMapping("/atualiza/{nomeNovo}/{id}")
    public ResponseEntity<Cliente> atualizaClientePorNomeCompleto(@PathVariable String nomeNovo, @PathVariable Long id) {
        Cliente cliente = clienteService.atualizaClientePorNomeCompleto(nomeNovo, id);
        logger.trace("method atualizaClientePorNomeCompleto accessed");
        return ResponseEntity.ok(cliente);
    }
}
