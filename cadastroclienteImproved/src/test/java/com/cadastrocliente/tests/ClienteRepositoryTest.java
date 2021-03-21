package com.cadastrocliente.tests;

import com.cadastrocliente.models.Cliente;
import com.cadastrocliente.repositories.ClienteRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepositoryTest;

    @Test
    public void deveMostrarUmClientePeloSeuNome() {

        String nomeCliente = "Evandro Gaio";
        Cliente cliente = clienteRepositoryTest.findByNomeCompleto(nomeCliente);
        Assert.assertNotNull(cliente);
        Assert.assertEquals(nomeCliente, cliente.getNomeCompleto());

    }

    @Test
    public void naoDeveMostrarUmClientePeloSeuNome() {

        String nomeCliente = "Agamenon Macedo";
        Cliente cliente = clienteRepositoryTest.findByNomeCompleto(nomeCliente);
        Assert.assertNull(cliente);

    }
}
