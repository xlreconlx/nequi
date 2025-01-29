/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nequi.prueba.service;

import com.nequi.prueba.entity.Franquicia;
import com.nequi.prueba.entity.Sucursal;
import com.nequi.prueba.repository.FranquiciaRepository;
import com.nequi.prueba.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ander
 */
@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;
    private FranquiciaRepository franquiciaRepository;
    
    public Sucursal addSucursal(Long franquiciaId, Sucursal sucursal) {
        Franquicia franquicia = franquiciaRepository.findByIdFranquicia(franquiciaId);
        if(franquicia == null){
            return null;
        }
        return sucursalRepository.save(sucursal);
    }
    
    public Sucursal updateFranquicia(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }
    
}
