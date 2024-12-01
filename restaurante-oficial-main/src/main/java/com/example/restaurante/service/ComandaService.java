package com.example.restaurante.service;

import java.util.List;

import com.example.restaurante.exceptions.ComandoSalvarException;
import com.example.restaurante.model.domain.Comanda;

public interface ComandaService {

    Comanda salvarComanda(Comanda comanda) throws ComandoSalvarException;
    void atualizar(Comanda comanda);
    void deletar (Comanda comanda);
    List<Comanda> listarComandas();

}
