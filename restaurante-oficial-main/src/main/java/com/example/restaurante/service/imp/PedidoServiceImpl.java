package com.example.restaurante.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurante.exceptions.PedidoSalvarException;
import com.example.restaurante.model.domain.Pedido;
import com.example.restaurante.repository.PedidoRepository;
import com.example.restaurante.service.PedidoService;


@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido salvarPedido(Pedido pedido) throws PedidoSalvarException {
        var pedidoSalvo = pedidoRepository.findByNumeroDoPedido(pedido.getNumeroDoPedido());
        if (pedidoSalvo.isPresent()) {
            throw new PedidoSalvarException("Pedido já existente!");
        }
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public void atualizar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public void deletar(Pedido pedido) {
        pedidoRepository.delete(pedido);
    }
    
}
