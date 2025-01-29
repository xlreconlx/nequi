/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nequi.prueba.service;

import com.nequi.prueba.entity.Franquicia;
import com.nequi.prueba.repository.FranquiciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ander
 */
@Service
public class FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public Franquicia addFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public Franquicia updateFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public List<Franquicia> getAllFranquicias() {
        return franquiciaRepository.findAll();
    }

    public Franquicia getFranquiciaById(Long id) {
        return franquiciaRepository.findByIdFranquicia(id);
    }
}
