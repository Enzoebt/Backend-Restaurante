package com.example.restaurante.model.domain;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "restaurantes")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String nomeRestaurante;
    private String cnpj;

    @OneToMany(mappedBy = "restaurante")
    private Set<Cliente> clientes = new HashSet<>();

   

    @OneToMany(mappedBy = "restaurante")
    private Set<Mesa> mesas = new HashSet<>();

    @OneToMany(mappedBy = "restaurante")
    private Set<Comanda> comandas = new HashSet<>();

}
