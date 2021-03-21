package com.apicrudpostgres.produto.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String nome;


    private BigDecimal quantidade;


    private BigDecimal valor;

}
