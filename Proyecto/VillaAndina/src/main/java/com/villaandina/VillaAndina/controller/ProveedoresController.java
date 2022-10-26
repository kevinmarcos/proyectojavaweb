
package com.villaandina.VillaAndina.controller;

import com.villaandina.VillaAndina.entity.ProveedoresEntity;
import com.villaandina.VillaAndina.service.ProveedoresService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/proveedores")
public class ProveedoresController {
    @Autowired
    private ProveedoresService  proveedoresservice;
    
    @GetMapping
    public List<ProveedoresEntity> findAll(){
        return proveedoresservice.findAll();
    }
}
