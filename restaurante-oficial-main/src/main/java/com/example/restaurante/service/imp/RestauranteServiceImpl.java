package com.example.restaurante.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restaurante.exceptions.RestauranteSalvarException;
import com.example.restaurante.model.domain.Restaurante;
import com.example.restaurante.repository.RestauranteRepository;
import com.example.restaurante.service.RestauranteService;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public Restaurante salvarRestaurante(Restaurante restaurante) throws RestauranteSalvarException {
        var restauranteSalvo = restauranteRepository.findByNomeRestaurante(restaurante.getNomeRestaurante());
        if (restauranteSalvo.isPresent()) {
            throw new RestauranteSalvarException("Restaurante já está cadastrado!");
        }
        return restauranteRepository.save(restaurante); 
    }

    @Override
    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.findAll();   
    }

    @Override
    public void atualizar(Restaurante restaurante) {
        restauranteRepository.save(restaurante);
    }

    @Override
    public void deletar(Restaurante restaurante) {
        restauranteRepository.delete(restaurante);
    }
    
}
