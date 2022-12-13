
package com.villandinaweb.controller;

import com.villandinaweb.entity.DistritoEntity;
import com.villandinaweb.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DistritoControllerWeb {
    @Autowired
    private DistritoService servicio;

    @GetMapping("/listardistrito")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("distrito", servicio.findAll());
        return "listardistrito";
    }
 
    @GetMapping("/registrodistrito")
    public String MostrarFormularioRegistro() {
        //es el nombre que tendra la pagina web
        return "registrodistrito";
    }
    
    @ModelAttribute("distrito")
    public DistritoEntity RegistroCategoria() {
        return new DistritoEntity();
    }
    
    @PostMapping("/registrodistrito")
    public String RegistroCProductos(
            @ModelAttribute("distrito") DistritoEntity c) {
        servicio.add(c);
        return "redirect:/listardistrito?correcto";
    }
    
    @GetMapping("/actualizadistrito/{id}")
    public String MostrarFormularioActualiza(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("distrito", servicio.findById(id));
        return "actualizadistrito";
    }
    
    @PostMapping("/actualizadistrito/{id}")
    public String ActualizaCurso(@PathVariable Long id,
            @ModelAttribute("distrito") DistritoEntity c) {
        servicio.update(c);
        return "redirect:/listardistrito?actualizo";
    }
}
