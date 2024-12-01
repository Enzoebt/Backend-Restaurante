package com.example.restaurante.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurante.exceptions.ClienteSalvarException;
import com.example.restaurante.model.domain.Cliente;
import com.example.restaurante.repository.ClienteRepository;
import com.example.restaurante.service.ClienteService;



@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(Cliente cliente) throws ClienteSalvarException {
        var clienteSalvo = clienteRepository.findByCpf(cliente.getCpf());
        if (clienteSalvo.isPresent()) {
            throw new ClienteSalvarException("Cliente já cadastrado.");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void deletar(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }
}
