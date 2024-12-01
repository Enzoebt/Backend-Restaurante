package com.example.restaurante.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurante.exceptions.MesasSalvarException;
import com.example.restaurante.model.domain.Mesa;
import com.example.restaurante.repository.MesasRepository;
import com.example.restaurante.service.MesasService;



@Service
public class MesasServiceImpl implements MesasService {

    @Autowired
    private MesasRepository mesasRepository;

    @Override
    public Mesa salvar(Mesa mesa) throws MesasSalvarException {
        var mesaSalva = mesasRepository.findByNum(mesa.getNum());
        if (mesaSalva.isPresent()) {
            throw new MesasSalvarException("Mesa já registrada.");
        }
        return mesasRepository.save(mesa);
    }

    @Override
    public void atualizar(Mesa mesa) {
        mesasRepository.save(mesa);
    }

    @Override
    public void deletar(Mesa mesa) {
        mesasRepository.delete(mesa);
    }

    @Override
    public List<Mesa> listar() {
        return mesasRepository.findAll();
    }
}
