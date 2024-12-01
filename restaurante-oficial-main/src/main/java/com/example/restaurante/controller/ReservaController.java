package com.example.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurante.exceptions.ReservaSalvarException;
import com.example.restaurante.model.domain.Reserva;
import com.example.restaurante.service.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @PostMapping
    public Reserva salvar(@RequestBody Reserva reserva) throws ReservaSalvarException {
        return reservaService.salvar(reserva);
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaService.listar();
    }   
}
