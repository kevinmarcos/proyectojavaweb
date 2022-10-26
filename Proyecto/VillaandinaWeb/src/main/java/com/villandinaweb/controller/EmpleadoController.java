
package com.villandinaweb.controller;

import com.villandinaweb.entity.EmpleadoEntity;
import com.villandinaweb.service.EmpleadoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("/custom")
    public List<EmpleadoEntity> findAllCustom(){
        return empleadoservice.findAll();
    }
    
    @GetMapping("/(id)")
    public Optional<EmpleadoEntity> findById(@PathVariable Long id){
        return empleadoservice.findById(id);
    }
    
    @PostMapping
    public EmpleadoEntity add(@RequestBody EmpleadoEntity e){
        return empleadoservice.add(e);
    }
    
    @PutMapping("/(id)")
    public EmpleadoEntity update(@PathVariable Long id, @RequestBody EmpleadoEntity e){
        e.setCodigo(id);
        return empleadoservice.update(e);
    }
    
    @DeleteMapping
    public EmpleadoEntity delete(@PathVariable Long id, @RequestBody EmpleadoEntity e){
        EmpleadoEntity objcategoria = new EmpleadoEntity();
        objcategoria.setEstado(false);
        return empleadoservice.delete(EmpleadoEntity.builder().codigo(id).build());
    }
}
