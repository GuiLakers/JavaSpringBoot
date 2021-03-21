package com.cadastrocliente.tests;

import com.cadastrocliente.models.Cidade;
import com.cadastrocliente.repositories.CidadeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CidadeRepositoryTest {

    @Autowired
    private CidadeRepository cidadeRepositoryTest;

    @Test
    public void deveMostrarUmaCidadePeloNome() {

        String nomeCidade = "Muriae";
        Cidade cidade = cidadeRepositoryTest.findByNome(nomeCidade);
        Assert.assertNotNull(cidade);
        Assert.assertEquals(nomeCidade, cidade.getNome());

    }

    @Test
    public void naoDeveMostrarUmaCidadePeloNome() {

        String nomeCidade = "Sao Joao de Meriti";
        Cidade cidade = cidadeRepositoryTest.findByNome(nomeCidade);
        Assert.assertNull(cidade);

    }

    @Test
    public void deveMostrarUmaCidadaPeloEstado() {

        String nomeCidade = "Amazonas";
        Cidade cidade = cidadeRepositoryTest.findByEstado(nomeCidade);
        Assert.assertNotNull(cidade);
        Assert.assertEquals(nomeCidade, cidade.getEstado());

    }

    @Test
    public void naoDeveMostrarUmaCidadePeloEstado() {

        String nomeCidade = "Acre";
        Cidade cidade = cidadeRepositoryTest.findByEstado(nomeCidade);
        Assert.assertNull(cidade);

    }
}
