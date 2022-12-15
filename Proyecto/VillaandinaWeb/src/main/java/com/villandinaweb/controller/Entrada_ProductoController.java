
package com.villandinaweb.controller;




import com.villandinaweb.entity.Entrada_ProductoEntity;
import com.villandinaweb.service.Entrada_ProductoService;
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

@RequestMapping("/entrada_producto")
public class Entrada_ProductoController {
    @Autowired
    private Entrada_ProductoService  entrada_productoservice;
    
    @GetMapping
    public List<Entrada_ProductoEntity> findAll(){
        return entrada_productoservice.findAll();
    }
    
    @GetMapping("/custom")
    public List<Entrada_ProductoEntity> findAllCustom(){
        return entrada_productoservice.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Entrada_ProductoEntity findById(@PathVariable Long id){
        return entrada_productoservice.findById(id);
    }
    
    @PostMapping
    public Entrada_ProductoEntity add(@RequestBody Entrada_ProductoEntity e){
        return entrada_productoservice.add(e);
    }
    
    @PutMapping("/{id}")
    public Entrada_ProductoEntity update(@PathVariable Long id, @RequestBody Entrada_ProductoEntity e){
        e.setCodigo(id);
        return entrada_productoservice.update(e);
    }
    
    @DeleteMapping("/{id}")
    public Entrada_ProductoEntity delete(@PathVariable Long id){
        Entrada_ProductoEntity objentprod = new Entrada_ProductoEntity();
        objentprod.setEstado(false);
        return entrada_productoservice.delete(Entrada_ProductoEntity.builder().codigo(id).build());
    }
}
