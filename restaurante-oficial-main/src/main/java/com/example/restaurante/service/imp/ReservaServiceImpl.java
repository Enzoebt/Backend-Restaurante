package com.example.restaurante.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurante.exceptions.ReservaSalvarException;
import com.example.restaurante.model.domain.Reserva;
import com.example.restaurante.repository.ReservaRepository;
import com.example.restaurante.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public Reserva salvar(Reserva reserva) throws ReservaSalvarException {
        var reservaSalva = reservaRepository.findByNumReserva(reserva.getNumReserva());// coloquei para numero da reserva pois, pode se ter varias reservas no mesmo dia
            if(reservaSalva.isPresent()){
                throw new ReservaSalvarException("Está reserva está ativa");

            }
            return reservaRepository.save(reserva);
        }

    @Override
    public void atualizar(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    public void deletar(Reserva reserva) {
        reservaRepository.delete(reserva);
    }

    @Override
    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

}

