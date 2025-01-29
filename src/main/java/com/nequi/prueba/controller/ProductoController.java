/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nequi.prueba.controller;

import com.nequi.prueba.entity.Producto;
import com.nequi.prueba.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ander
 */
@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    // Endpoint para obtener el producto con más stock por sucursal en una franquicia
    @GetMapping("/franquicia/{idFranquicia}/productos-by-stock")
    public List<Producto> getProductoByStockAndByFranquicia(@PathVariable Long idFranquicia) {
        return productoService.getProductoByStockAndByFranquicia(idFranquicia);
    }
}
