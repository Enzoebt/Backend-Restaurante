package com.example.restaurante.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restaurante.exceptions.ComandoSalvarException;
import com.example.restaurante.model.domain.Comanda;
import com.example.restaurante.repository.ComandaRepository;
import com.example.restaurante.service.ComandaService;

@Service
public class ComandaServiceImpl implements ComandaService {

    @Autowired
    private ComandaRepository comandaRepository;

    @Override
    public Comanda salvarComanda(Comanda comanda) throws ComandoSalvarException {
        var comandaSalvo = comandaRepository.findByNumeroDaComanda(comanda.getNumeroDaComanda());
        
        if(comandaSalvo.isPresent()){
            throw new ComandoSalvarException("Essa comanda já tem um cliente");
        }
        return comandaRepository.save(comanda);
        
    }

    @Override
    public List<Comanda> listarComandas() {
        return comandaRepository.findAll();
    }

    @Override
    public void atualizar(Comanda comanda) {
        comandaRepository.save(comanda);
    }

    @Override
    public void deletar(Comanda comanda) {
        comandaRepository.delete(comanda);
    }
    
}
