/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nequi.prueba.repository;

import com.nequi.prueba.entity.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ander
 */
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    public List<Producto> findByIdSucursal(Long idSucursal);
}
