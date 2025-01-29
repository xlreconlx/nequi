/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nequi.prueba.repository;

import com.nequi.prueba.entity.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ander
 */
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long>{
    public Franquicia findByIdFranquicia(Long idTarea);
}
