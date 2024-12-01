package com.example.restaurante.service;

import java.util.List;

import com.example.restaurante.exceptions.ClienteSalvarException;
import com.example.restaurante.model.domain.Cliente;

public interface ClienteService {

    Cliente salvar(Cliente cliente) throws ClienteSalvarException;
    void atualizar(Cliente cliente);
    void deletar (Cliente cliente);
    List<Cliente> listar();

}
