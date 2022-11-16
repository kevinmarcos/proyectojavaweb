
package com.villandinaweb.controller;




import com.villandinaweb.entity.Detalle_SalidaEntity;
import com.villandinaweb.service.Detalle_SalidaService;
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

@RequestMapping("/detalle_salida")
public class Detalle_SalidaController {
    @Autowired
    private Detalle_SalidaService  detalle_salidaservice;
    
    @GetMapping
    public List<Detalle_SalidaEntity> findAll(){
        return detalle_salidaservice.findAll();
    }
    
    @GetMapping("/custom")
    public List<Detalle_SalidaEntity> findAllCustom(){
        return detalle_salidaservice.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<Detalle_SalidaEntity> findById(@PathVariable Long id){
        return detalle_salidaservice.findById(id);
    }
    
    @PostMapping
    public Detalle_SalidaEntity add(@RequestBody Detalle_SalidaEntity e){
        return detalle_salidaservice.add(e);
    }
    
    @PutMapping("/{id}")
    public Detalle_SalidaEntity update(@PathVariable Long id, @RequestBody Detalle_SalidaEntity e){
        e.setCodigo(id);
        return detalle_salidaservice.update(e);
    }
    
    @DeleteMapping("/{id}")
    public Detalle_SalidaEntity delete(@PathVariable Long id){
        Detalle_SalidaEntity objdetasal = new Detalle_SalidaEntity();
        objdetasal.setEstado(false);
        return detalle_salidaservice.delete(Detalle_SalidaEntity.builder().codigo(id).build());
    }
}
