
package com.villandinaweb.controller;

import com.villandinaweb.entity.Salida_ProductoEntity;
import com.villandinaweb.service.DestinoService;
import com.villandinaweb.service.EmpleadoService;
import com.villandinaweb.service.Salida_ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Salida_ProductoControllerWeb {
    @Autowired
    private Salida_ProductoService servicio;
    
    @Autowired
    private EmpleadoService servicioempleado;
    
    @Autowired
    private DestinoService serviciodestino;

    @GetMapping("/listarsalidaproducto")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("salidaproducto", servicio.findAll());
        return "listarsalidaproducto";
    }
    
    @GetMapping("/registrosalidaproducto")
    public String MostrarFormularioRegistro(Model modelo) {
        //es el nombre que tendra la pagina web
        modelo.addAttribute("empleado", servicioempleado.findAll());
        modelo.addAttribute("destino", serviciodestino.findAll());
        return "registroentradaproducto";
    }
    @ModelAttribute("salidaproducto")
    public Salida_ProductoEntity RegistroProductos() {
        return new Salida_ProductoEntity();
    }
    
    @PostMapping("/registrosalidaproducto")
    public String RegistroCProductos(
            @ModelAttribute("entradaproducto") Salida_ProductoEntity c) {
        servicio.add(c);
        return "redirect:/listarsalidaproducto?correcto";
    }
}
