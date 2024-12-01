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
import com.example.restaurante.exceptions.PedidoSalvarException;
import com.example.restaurante.model.domain.Pedido;
import com.example.restaurante.repository.PedidoRepository;
import com.example.restaurante.service.PedidoService;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidosRepository;

    @Autowired
    private PedidoService pedidosService;

    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido)
        throws PedidoSalvarException {
            return pedidosService.salvarPedido(pedido);
        }
    
    @GetMapping
        public List<Pedido> listar() {
            return pedidosService.listarPedidos();
        }

    @GetMapping("/{id}")
        public ResponseEntity<Pedido> buscarPorId(@PathVariable("id") Long id) {
            var pedido = pedidosRepository.findById(id);
            if(pedido.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(pedido.get());
        }
}
