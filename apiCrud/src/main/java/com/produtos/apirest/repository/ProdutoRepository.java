
package com.produtos.apirest.repository;

import com.produtos.apirest.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Jpa repository ja possui varios metodos prontos para a persintencia no banco
//Com isso nao precisa criar nenhum tipo de DAO..somente criar uma instancia e usar os metodos
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    
    Produto findById(long id);
    
   
}
