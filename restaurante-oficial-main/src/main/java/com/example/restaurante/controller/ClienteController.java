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

import com.example.restaurante.exceptions.ClienteSalvarException;
import com.example.restaurante.model.domain.Cliente;
import com.example.restaurante.repository.ClienteRepository;
import com.example.restaurante.service.ClienteService;



@RestController
@RequestMapping("/cliente")
public class ClienteController {
  
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente)
        throws ClienteSalvarException {
            return clienteService.salvar(cliente);
        }

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable("id") Long id) {
        var cliente = clienteRepository.findById(id);
        if(cliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cliente.get());
    }
    
}
