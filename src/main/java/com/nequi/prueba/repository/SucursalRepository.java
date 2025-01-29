/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nequi.prueba.repository;

import com.nequi.prueba.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ander
 */
public interface SucursalRepository extends JpaRepository<Sucursal, Long>{
    
}
