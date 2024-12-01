package com.example.restaurante.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurante.model.domain.Mesa;

public interface MesasRepository extends JpaRepository<Mesa, Long>{
    Optional<Mesa> findByNum(Integer num);
}
