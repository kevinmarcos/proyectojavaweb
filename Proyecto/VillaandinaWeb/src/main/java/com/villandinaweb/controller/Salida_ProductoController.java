
package com.villandinaweb.controller;




import com.villandinaweb.entity.Salida_ProductoEntity;
import com.villandinaweb.service.Salida_ProductoService;
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

@RequestMapping("/salida_producto")
public class Salida_ProductoController {
    @Autowired
    private Salida_ProductoService  salida_productoservice;
    
    @GetMapping
    public List<Salida_ProductoEntity> findAll(){
        return salida_productoservice.findAll();
    }
    
    @GetMapping("/custom")
    public List<Salida_ProductoEntity> findAllCustom(){
        return salida_productoservice.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<Salida_ProductoEntity> findById(@PathVariable Long id){
        return salida_productoservice.findById(id);
    }
    
    @PostMapping
    public Salida_ProductoEntity add(@RequestBody Salida_ProductoEntity e){
        return salida_productoservice.add(e);
    }
    
    @PutMapping("/{id}")
    public Salida_ProductoEntity update(@PathVariable Long id, @RequestBody Salida_ProductoEntity e){
        e.setCodigo(id);
        return salida_productoservice.update(e);
    }
    
    @DeleteMapping("/{id}")
    public Salida_ProductoEntity delete(@PathVariable Long id){
        Salida_ProductoEntity objsalprod = new Salida_ProductoEntity();
        objsalprod.setEstado(false);
        return salida_productoservice.delete(Salida_ProductoEntity.builder().codigo(id).build());
    }
}
