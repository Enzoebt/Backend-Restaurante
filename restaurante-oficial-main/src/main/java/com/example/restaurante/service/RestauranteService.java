package com.example.restaurante.service;

import java.util.List;

import com.example.restaurante.exceptions.RestauranteSalvarException;
import com.example.restaurante.model.domain.Restaurante;

public interface RestauranteService {

    Restaurante salvarRestaurante(Restaurante restaurante) throws RestauranteSalvarException;
    void atualizar(Restaurante restaurante);
    void deletar (Restaurante restaurante);
    List<Restaurante> listarRestaurantes();

}
