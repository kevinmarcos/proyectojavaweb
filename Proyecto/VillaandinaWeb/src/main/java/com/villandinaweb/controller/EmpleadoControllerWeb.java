/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villandinaweb.controller;

import com.villandinaweb.entity.EmpleadoEntity;
import com.villandinaweb.service.DistritoService;
import com.villandinaweb.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmpleadoControllerWeb {

    @Autowired
    private EmpleadoService servicio;

    @Autowired
    private DistritoService serviciodistrito;
        
    @GetMapping("/listarempleado")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("empleado", servicio.findAll());
        return "listarempleado";
    }
    
    @GetMapping("/registroempleado")
    public String MostrarFormularioRegistro(Model modelo) {
        //es el nombre que tendra la pagina web
        modelo.addAttribute("distrito", serviciodistrito.findAll());
        return "registroempleado";
    }
    
    @ModelAttribute("empleado")
    public EmpleadoEntity RegistroEmpleado() {
        return new EmpleadoEntity();
    }
    
    @PostMapping("/registroempleado")
    public String RegistroCProductos(
            @ModelAttribute("empleado") EmpleadoEntity c) {
        servicio.add(c);
        return "redirect:/listarempleado?correcto";
    }
}

