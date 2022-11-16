
package com.villandinaweb.controller;

//@RestController define la clase como un controlador.

import com.villandinaweb.entity.CategoriaEntity;
import com.villandinaweb.service.CategoriaService;
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

@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService  categoriaservice;
    
    @GetMapping
    public List<CategoriaEntity> findAll(){
        return categoriaservice.findAll();
    }
    
    @GetMapping("/custom")
    public List<CategoriaEntity> findAllCustom(){
        return categoriaservice.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<CategoriaEntity> findById(@PathVariable Long id){
        return categoriaservice.findById(id);
    }
    
    @PostMapping
    public CategoriaEntity add(@RequestBody CategoriaEntity c){
        return categoriaservice.add(c);
    }
    
    @PutMapping("/{id}")
    public CategoriaEntity update(@PathVariable Long id, @RequestBody CategoriaEntity c){
        c.setCodigo(id);
        return categoriaservice.update(c);
    }
    
    @DeleteMapping("/{id}")
    public CategoriaEntity delete(@PathVariable Long id){
        CategoriaEntity objcategoria = new CategoriaEntity();
        objcategoria.setEstado(false);
        return categoriaservice.delete(CategoriaEntity.builder().codigo(id).build());
    }
}
