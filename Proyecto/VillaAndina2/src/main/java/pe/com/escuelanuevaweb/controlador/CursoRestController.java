/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.escuelanuevaweb.controlador;

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
import pe.com.escuelanuevaweb.modelo.CursoEntity;
import pe.com.escuelanuevaweb.servicio.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoRestController {

    @Autowired
    private CursoService cursoservice;

    //@GetMapping sirve para obtener valores
    @GetMapping
    public List<CursoEntity> findAll() {
        return cursoservice.findAll();
    }

    @GetMapping("/custom")
    public List<CursoEntity> findAllCustom() {
        return cursoservice.findAllCustom();
    }

    @GetMapping("/{id}")
    public CursoEntity findById(@PathVariable Long id) {
        return cursoservice.findById(id);
    }

    //@PostMapping permite enviar(registrar) valores
    @PostMapping
    public CursoEntity add(@RequestBody CursoEntity c) {
        return cursoservice.add(c);
    }

    //@PutMapping permite actualizar
    @PutMapping("/{id}")
    public CursoEntity update(@PathVariable Long id, @RequestBody CursoEntity c) {
        c.setCodigo(id);
        return cursoservice.update(c);
    }

    //@DeleteMapping permite eliminar un valor
    @DeleteMapping("/{id}")
    public CursoEntity delete(@PathVariable Long id) {
        //c.setCodigo(id);
        //return carreraservice.delete(c);
        CursoEntity objcategoria = new CursoEntity();
        objcategoria.setEstado(false);
        return cursoservice.delete(CursoEntity.builder().codigo(id).build());
    }

    @PostMapping("/habilitar/{id}")
    public CursoEntity enable(@PathVariable Long id) {
        CursoEntity objcategoria = new CursoEntity();
        objcategoria.setEstado(true);
        return cursoservice.enable(CursoEntity.builder().codigo(id).build());
    }
}
