package com.example.restaurante.model.domain;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private Integer numReserva; // Numero da Reserva

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    protected Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "mesa_id", nullable = false)
    protected Mesa mesa;

    protected LocalDate data; //Correção para LocalDate - Brendo

}