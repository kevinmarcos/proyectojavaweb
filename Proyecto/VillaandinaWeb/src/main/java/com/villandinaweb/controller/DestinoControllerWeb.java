
package com.villandinaweb.controller;

import com.villandinaweb.entity.DestinoEntity;
import com.villandinaweb.service.DestinoService;
import com.villandinaweb.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DestinoControllerWeb {
    @Autowired
    private DestinoService servicio;
    
    @Autowired
    private DistritoService serviciodistrito;

    @GetMapping("/listardestino")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("destino", servicio.findAll());
        return "listardestino";
    }
    
    @GetMapping("/registrodestino")
    public String MostrarFormularioRegistro(Model modelo) {
        //es el nombre que tendra la pagina web
        modelo.addAttribute("distrito", serviciodistrito.findAll());
        return "registrodestino";
    }
    @ModelAttribute("destino")
    public DestinoEntity RegistroProductos() {
        return new DestinoEntity();
    }
    
    @PostMapping("/registrodestino")
    public String RegistroCProductos(
            @ModelAttribute("destino") DestinoEntity c) {
        servicio.add(c);
        return "redirect:/listardestino?correcto";
    }
}

