package com.example.restaurante.service;

import java.util.List;

import com.example.restaurante.exceptions.PedidoSalvarException;
import com.example.restaurante.model.domain.Pedido;

public interface PedidoService {

    Pedido salvarPedido(Pedido pedido) throws PedidoSalvarException;
    void atualizar(Pedido pedido);
    void deletar (Pedido pedido);
    List<Pedido> listarPedidos();

}
