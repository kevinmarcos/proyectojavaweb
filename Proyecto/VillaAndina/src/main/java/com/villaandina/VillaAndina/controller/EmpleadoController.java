
package com.villaandina.VillaAndina.controller;

import com.villaandina.VillaAndina.entity.EmpleadoEntity;
import com.villaandina.VillaAndina.service.EmpleadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService  empleadoservice;
    
    @GetMapping
    public List<EmpleadoEntity> findAll(){
        return empleadoservice.findAll();
    }
}
