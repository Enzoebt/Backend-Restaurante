package com.example.restaurante.service;

import java.util.List;

import com.example.restaurante.exceptions.ReservaSalvarException;
import com.example.restaurante.model.domain.Reserva;

public interface ReservaService {

    Reserva salvar(Reserva reserva) throws ReservaSalvarException; 
    void atualizar(Reserva reserva);
    void deletar(Reserva reserva);
    List<Reserva> listar();
}
