/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.gih.Garagem.services;

import br.eti.gih.Garagem.DTO.VeiculoDTO;
import br.eti.gih.Garagem.entities.Veiculo;
import br.eti.gih.Garagem.repositories.GaragemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesideva
 */
@Service
public class GaragemService {
    
    @Autowired
    private GaragemRepository garagemRepository;
    
    public List<Veiculo> findAll(){
        
        List<Veiculo> result = garagemRepository.findAll();
        return result;
    }
    
    public List<Veiculo> findById(long id) {
        List<Veiculo> result = garagemRepository.findById(id);
        return result;
    }
    
    public List<VeiculoDTO> findByCorIgnoreCase( String cor){
        List<Veiculo> resultVeiculo = garagemRepository.findByCorIgnoreCase(cor);
        
        List<VeiculoDTO> resultDTO = resultVeiculo.stream()
                .map(x -> new VeiculoDTO(x)).toList();
        
        return resultDTO;
    }
    
}

