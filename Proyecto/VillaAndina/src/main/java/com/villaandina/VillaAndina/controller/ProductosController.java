
package com.villaandina.VillaAndina.controller;

import com.villaandina.VillaAndina.entity.ProductosEntity;
import com.villaandina.VillaAndina.service.ProductosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private ProductosService  productosservice;
    
    @GetMapping
    public List<ProductosEntity> findAll(){
        return productosservice.findAll();
    }
}
