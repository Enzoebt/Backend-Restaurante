package com.example.restaurante.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurante.model.domain.Reserva;

// Alterei para (LocalDate)
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Optional<Reserva> findByData(LocalDate data);
    Optional<Reserva> findByNumReserva(Integer numReserva);
}
