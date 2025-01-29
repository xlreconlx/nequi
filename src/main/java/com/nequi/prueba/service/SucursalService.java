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
    
    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public Sucursal addSucursal(Long idFranquicia, Sucursal sucursal) {
        Franquicia franquicia = franquiciaRepository.findByIdFranquicia(idFranquicia);
        if (franquicia == null) {
            return null;
        }
        sucursal.setIdFranquicia(franquicia.getIdFranquicia());
        return sucursalRepository.save(sucursal);
    }

    public Sucursal updateSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Sucursal updateNombreSucursal(Long idSucursal, Sucursal sucursal) {
        Sucursal sucursalSearch = sucursalRepository.getSucursalByIdSucursal(idSucursal);
        if (sucursalSearch == null) {
            return null;
        }
        sucursalSearch.setNombre(sucursal.getNombre());
        return sucursalRepository.save(sucursalSearch);
    }

}
