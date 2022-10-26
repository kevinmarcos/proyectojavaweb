
package com.villaandina.VillaAndina.controller;

import com.villaandina.VillaAndina.entity.DistritoEntity;
import com.villaandina.VillaAndina.service.DistritoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/distrito")
public class DistritoController {
    @Autowired
    private DistritoService  distritoservice;
    
    @GetMapping
    public List<CategoriaEntity> findAll(){
        return categoriaservice.findAll();
    }
    
    @GetMapping("/custom")
    public List<CategoriaEntity> findAllCustom(){
        return categoriaservice.findAll();
    }
    
    @GetMapping("/(id)")
    public Optional<CategoriaEntity> findById(@PathVariable Long id){
        return categoriaservice.findById(id);
    }
    
    @PostMapping
    public CategoriaEntity add(@RequestBody CategoriaEntity c){
        return categoriaservice.add(c);
    }
    
    @PutMapping("/(id)")
    public CategoriaEntity update(@PathVariable Long id, @RequestBody CategoriaEntity c){
        c.setCodigo(id);
        return categoriaservice.update(c);
    }
    
    @DeleteMapping
    public CategoriaEntity delete(@PathVariable Long id, @RequestBody CategoriaEntity c){
        CategoriaEntity objcategoria = new CategoriaEntity();
        objcategoria.setEstado(false);
        return categoriaservice.delete(CategoriaEntity.builder().codigo(id).build());
    }
}
