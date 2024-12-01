package com.example.restaurante.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.restaurante.exceptions.ComandoSalvarException;
import com.example.restaurante.model.domain.Comanda;
import com.example.restaurante.repository.ComandaRepository;
import com.example.restaurante.service.ComandaService;


@RestController
@RequestMapping("/comanda")
public class ComandaController {
    
    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private ComandaService comandaService;

    @PostMapping
    public Comanda salvar(@RequestBody Comanda comanda)
        throws ComandoSalvarException {
            return comandaService.salvarComanda(comanda);
        }
    
    @GetMapping
        public List<Comanda> listar() {
            return comandaService.listarComandas();
        }

    @GetMapping("/{id}")
        public ResponseEntity<Comanda> buscarPorId(@PathVariable("id") Long id) {
            var comanda = comandaRepository.findById(id);
            if(comanda.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(comanda.get());
        }
}
