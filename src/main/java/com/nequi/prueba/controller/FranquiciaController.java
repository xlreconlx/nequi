/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nequi.prueba.controller;

import com.nequi.prueba.entity.Franquicia;
import com.nequi.prueba.service.FranquiciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/franquicia")
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;

    @PostMapping
    public Franquicia addFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.addFranquicia(franquicia);
    }

    @GetMapping
    public List<Franquicia> getAllFranquicias() {
        return franquiciaService.getAllFranquicias();
    }

    @GetMapping("/{id}")
    public Franquicia getFranquiciaById(@PathVariable Long id) {
        return franquiciaService.getFranquiciaById(id);
    }
    
    @PutMapping("/{idFranquicia}")
    public ResponseEntity<?> updateTarea(@PathVariable Long idFranquicia, @RequestBody Franquicia franquicia) {
        Franquicia oldFranquicia = franquiciaService.getFranquiciaById(idFranquicia);
        if (oldFranquicia != null) {
            oldFranquicia.setNombre(franquicia.getNombre());
            return ResponseEntity.ok(franquiciaService.updateFranquicia(oldFranquicia));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("Franquicia no encontrada");
        }
    }

}
