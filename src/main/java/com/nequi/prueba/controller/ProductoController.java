/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nequi.prueba.controller;

import com.nequi.prueba.entity.Producto;
import com.nequi.prueba.service.ProductoService;
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
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public Producto addProducto(@RequestBody Producto producto) {
        return productoService.addProducto(producto);
    }

    @PutMapping("/{idProducto}")
    public Producto updateProducto(@PathVariable Long idProducto, @RequestBody Producto producto) {
        return productoService.updateNombreProducto(idProducto, producto);
    }

    @GetMapping("/franquicia/{idFranquicia}/productos-by-stock")
    public List<Producto> getProductoByStockAndByFranquicia(@PathVariable Long idFranquicia) {
        return productoService.getProductoByStockAndByFranquicia(idFranquicia);
    }
}
