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
import com.example.restaurante.exceptions.MesasSalvarException;
import com.example.restaurante.model.domain.Mesa;
import com.example.restaurante.repository.MesasRepository;
import com.example.restaurante.service.MesasService;


@RestController
@RequestMapping("/mesa")
public class MesaController {
    
    @Autowired
    private MesasRepository mesasRepository;

    @Autowired
    private MesasService mesasService;

    @PostMapping
    public Mesa salvar(@RequestBody Mesa mesa)
        throws MesasSalvarException {
            return mesasService.salvar(mesa);
        }
    
    @GetMapping
        public List<Mesa> listar() {
            return mesasService.listar();
        }

    @GetMapping("/{id}")
        public ResponseEntity<Mesa> buscarPorId(@PathVariable("id") Long id) {
            var mesa = mesasRepository.findById(id);
            if(mesa.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(mesa.get());
        }
}
