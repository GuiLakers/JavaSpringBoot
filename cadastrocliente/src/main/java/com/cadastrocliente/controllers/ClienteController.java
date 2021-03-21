package com.cadastrocliente.controllers;

import com.cadastrocliente.models.Cliente;
import com.cadastrocliente.services.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @GetMapping("/encontraClientePorNomeCompleto/{nomeCompleto}")
    public Cliente encontraClientePorNomeCompleto(@PathVariable String nomeCompleto) {
        return clienteService.encontraClientePorNomeCompleto(nomeCompleto);
    }

    @GetMapping("/encontraClientePorId/{id}")
    public Cliente encontraClientePorId(@PathVariable Long id) {

        return clienteService.encontraClientePorId(id);
    }

    @PostMapping("/cadastraCliente")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastraCliente(@RequestBody Cliente cliente) {
        clienteService.cadastraCliente(cliente);
        return "Cadastrado com sucesso!";

    }

    @DeleteMapping("/removeCliente/{id}")
    public String removeCliente(@PathVariable Long id) {
        clienteService.removeCliente(id);
        return "Deletado com sucesso!";
    }

    @PatchMapping("/atualizaClientePorNomeCompleto/{nomeNovo}/{id}")
    public Cliente atualizaClientePorNomeCompleto(@PathVariable String nomeNovo, @PathVariable Long id) {

        Cliente cliente = clienteService.atualizaClientePorNomeCompleto(nomeNovo, id);

        return cliente;
    }

}
