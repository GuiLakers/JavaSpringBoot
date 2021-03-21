package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Essa anotacao eh a correta quando tem uma view 
 //@Controller
//Essa anotacao eh para API que retorna objetos(Json ou outros) nao para views
@RestController
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;
    
 
////Esses 2 metodos abaixo sao um exemplo de formulario pra uma base de dados///////   
    //metodo que chama o formulario de cadastro
    @GetMapping("/cadastroProduto")
    public String inicio() {
        return "cadastro/cadastroProduto";
    }

   
    //metodo que salva o formulario e redireciona pro proprio formulario
    @PostMapping("/salvarProduto")
    public String salvar(Produto produto) {
       produtoRepository.save(produto);
        return "cadastro/cadastroProduto";

    }
    
    
 /////////////////////////////metodos daqui pra baixo sao metodos de um CRUD//////////  
    //"Retorna uma lista de Produtos")
    @GetMapping("/produtos")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    

    }
    //"Retorna um produto unico")

    @GetMapping(value = "/produto/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE})
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }

    //"Salva um produto")
//Nao precisa colocar id do produto a ser salvo no postman, se ja estiver automatico no banco de dados
    @PostMapping(value = "/cadastrarProduto", consumes = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE})
    public String submitForm(@ModelAttribute("produto") Produto produto) {
        System.out.println(produto);
        return "registrado com sucesso!!!";

    }

    //"Deleta um produto")
    @DeleteMapping("/produto")
    public void deletaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    //"Atualiza um produto")
    @PutMapping("/produto")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

}
