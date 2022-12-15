
package com.villandinaweb.controller;




import com.villandinaweb.entity.Detalle_EntradaEntity;
import com.villandinaweb.service.Detalle_EntradaService;
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

@RequestMapping("/detalle_entrada")
public class Detalle_EntradaController {
    @Autowired
    private Detalle_EntradaService  detalle_entradaservice;
    
    @GetMapping
    public List<Detalle_EntradaEntity> findAll(){
        return detalle_entradaservice.findAll();
    }
    
    @GetMapping("/custom")
    public List<Detalle_EntradaEntity> findAllCustom(){
        return detalle_entradaservice.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Detalle_EntradaEntity findById(@PathVariable Long id){
        return detalle_entradaservice.findById(id);
    }
    
    @PostMapping
    public Detalle_EntradaEntity add(@RequestBody Detalle_EntradaEntity e){
        return detalle_entradaservice.add(e);
    }
    
    @PutMapping("/{id}")
    public Detalle_EntradaEntity update(@PathVariable Long id, @RequestBody Detalle_EntradaEntity e){
        e.setCodigo(id);
        return detalle_entradaservice.update(e);
    }
    
    @DeleteMapping("/{id}")
    public Detalle_EntradaEntity delete(@PathVariable Long id){
        Detalle_EntradaEntity objdetaent = new Detalle_EntradaEntity();
        objdetaent.setEstado(false);
        return detalle_entradaservice.delete(Detalle_EntradaEntity.builder().codigo(id).build());
    }
}
