/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nequi.prueba.service;

import com.nequi.prueba.entity.Producto;
import com.nequi.prueba.entity.Sucursal;
import com.nequi.prueba.repository.ProductoRepository;
import com.nequi.prueba.repository.SucursalRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ander
 */
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    public Producto addProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long productoId) {
        productoRepository.deleteById(productoId);
    }

    public Producto updateStock(Long productoId, int stock) {
        Producto producto = productoRepository.findById(productoId).orElseThrow();
        producto.setStock(stock);
        return productoRepository.save(producto);
    }
    
    public Producto updateNombreProducto(Long productoId, Producto producto) {
        Producto productoSearch = productoRepository.findById(productoId).orElseThrow();
        productoSearch.setNombre(producto.getNombre());
        return productoRepository.save(productoSearch);
    }

    public List<Producto> getProductoByStockAndByFranquicia(Long idFranquicia) {
        List<Sucursal> sucursales = sucursalRepository.getAllSucursalByIdFranquicia(idFranquicia);
        List<Producto> productoList = new ArrayList<>();

        for (Sucursal sucursal : sucursales) {
            List<Producto> productos = productoRepository.findByIdSucursal(sucursal.getIdSucursal());

            if (productos.isEmpty()) {
                continue;
            }
            Producto productoConMasStock = productos.stream()
                    .max(Comparator.comparingInt(Producto::getStock))
                    .orElseThrow();

            productoList.add(productoConMasStock);
        }

        return productoList;
    }
}
