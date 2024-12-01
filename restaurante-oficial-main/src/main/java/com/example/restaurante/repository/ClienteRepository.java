package com.example.restaurante.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurante.model.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    Optional<Cliente> findByCpf(String cpf);
}
