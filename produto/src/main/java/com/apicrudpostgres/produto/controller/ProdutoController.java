package com.apicrudpostgres.produto.controller;

import com.apicrudpostgres.produto.model.Produto;
import com.apicrudpostgres.produto.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();

    }

    @GetMapping(value = "/produto/{id}")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {

        return produtoRepository.findById(id);
    }

    @PostMapping(value = "/cadastrarProduto")
    public String submitForm(@RequestBody Produto produto) {
        System.out.println(produto);
        return "registrado com sucesso!!!";

    }

    @DeleteMapping("/produto")
    public void deletaProduto(@RequestBody Produto produto) {

        produtoRepository.delete(produto);
    }

    @PutMapping("/produto")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

}
