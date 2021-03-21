package com.cadastrocliente.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cadastrocliente.models.Cliente;
import com.cadastrocliente.repositories.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteService.class);

    public void cadastraCliente(Cliente cliente) {

        clienteRepository.save(cliente);
    }

    public void removeCliente(Long id) {

        clienteRepository.deleteById(id);

    }

    public Cliente encontraClientePorNomeCompleto(String nomeCompleto) {

        Cliente cliente = clienteRepository.findByNomeCompleto(nomeCompleto);

        Integer idade = mostraIdadeAtualCliente(cliente);
        cliente.setIdade(idade);

        return cliente;
    }

    public Cliente encontraClientePorId(Long id) {

        Optional<Cliente> clienteSalvo = clienteRepository.findById(id);
        Cliente cliente = clienteSalvo.get();

        Integer idade = mostraIdadeAtualCliente(cliente);
        cliente.setIdade(idade);

        return cliente;
    }

    public Cliente atualizaClientePorNomeCompleto(String nomeNovo, Long id) {

        Optional<Cliente> clienteSalvo = clienteRepository.findById(id);
        clienteSalvo.get().setNomeCompleto(nomeNovo);

        Integer idade = mostraIdadeAtualCliente(clienteSalvo.get());
        clienteSalvo.get().setIdade(idade);

        return clienteRepository.save(clienteSalvo.get());
    }

    public Integer mostraIdadeAtualCliente(Cliente cliente) {

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = cliente.getDataNascimento();

        Period periodo = dataNascimento.until(dataAtual);
        Integer idade = periodo.getYears();

        Integer idadeCliente = cliente.getIdade();
        if (idade > idadeCliente) {
            cliente.setIdade(idade);
            clienteRepository.save(cliente);
        }
        return idade;

    }

}
