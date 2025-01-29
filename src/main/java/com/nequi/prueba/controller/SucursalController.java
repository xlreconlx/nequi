/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nequi.prueba.controller;

import com.nequi.prueba.entity.Sucursal;
import com.nequi.prueba.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ander
 */
@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/franquicia/{idFranquicia}")
    public Sucursal agregarSucursal(@PathVariable Long idFranquicia, @RequestBody Sucursal sucursal) {
        return sucursalService.addSucursal(idFranquicia, sucursal);
    }
    
    @PutMapping("/{idSucursal}")
    public ResponseEntity<?> updateSucursal(@PathVariable Long idSucursal, @RequestBody Sucursal sucursal) {
        return ResponseEntity.ok(sucursalService.updateNombreSucursal(idSucursal, sucursal));
    }

}
