
package com.villandinaweb.controller;

import com.villandinaweb.entity.Entrada_ProductoEntity;
import com.villandinaweb.service.DestinoService;
import com.villandinaweb.service.EmpleadoService;
import com.villandinaweb.service.Entrada_ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Entrada_ProductoControllerWeb {
    @Autowired
    private Entrada_ProductoService servicio;
    
    @Autowired
    private EmpleadoService servicioempleado;
    
    @Autowired
    private DestinoService serviciodestino;

    @GetMapping("/listarentradaproducto")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("entradaproducto", servicio.findAll());
        return "listarentradaproducto";
    }
    
    @GetMapping("/registroentradaproducto")
    public String MostrarFormularioRegistro(Model modelo) {
        //es el nombre que tendra la pagina web
        modelo.addAttribute("empleado", servicioempleado.findAll());
        modelo.addAttribute("destino", serviciodestino.findAll());
        return "registroentradaproducto";
    }
    @ModelAttribute("entradaproducto")
    public Entrada_ProductoEntity RegistroProductos() {
        return new Entrada_ProductoEntity();
    }
    
    @PostMapping("/registroentradaproducto")
    public String RegistroCProductos(
            @ModelAttribute("entradaproducto") Entrada_ProductoEntity c) {
        servicio.add(c);
        return "redirect:/listarentradaproducto?correcto";
    }
}
