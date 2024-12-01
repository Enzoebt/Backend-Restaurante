package com.example.restaurante.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurante.model.domain.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {

    Optional<Comanda> findByNumeroDaComanda(Integer numeroComanda);

}
