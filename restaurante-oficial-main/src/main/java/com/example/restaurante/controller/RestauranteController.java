package com.example.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.restaurante.exceptions.RestauranteSalvarException;
import com.example.restaurante.model.domain.Restaurante;
import com.example.restaurante.service.RestauranteService;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;


    @PostMapping
    public Restaurante salvar(@Validated @RequestBody Restaurante restaurante) throws RestauranteSalvarException {
        return restauranteService.salvarRestaurante(restaurante);
    }

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteService.listarRestaurantes();
    }

}