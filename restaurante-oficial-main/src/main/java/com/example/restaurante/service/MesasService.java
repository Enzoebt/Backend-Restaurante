package com.example.restaurante.service;

import java.util.List;

import com.example.restaurante.model.domain.Mesa;


import com.example.restaurante.exceptions.MesasSalvarException;

public interface MesasService {

    Mesa salvar(Mesa mesa) throws MesasSalvarException;
    void atualizar(Mesa mesa);
    void deletar(Mesa mesa);
    List<Mesa> listar();
}
