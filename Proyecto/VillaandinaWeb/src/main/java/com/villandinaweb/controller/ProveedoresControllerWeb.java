
package com.villandinaweb.controller;

import com.villandinaweb.entity.ProveedoresEntity;
import com.villandinaweb.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProveedoresControllerWeb {
    @Autowired
    private ProveedoresService servicio;

    @GetMapping("/listarproveedor")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("proveedores", servicio.findAll());
        return "listarproveedor";
    }
 
    @GetMapping("/registroproveedores")
    public String MostrarFormularioRegistro() {
        //es el nombre que tendra la pagina web
        return "registroproveedores";
    }
    
    @ModelAttribute("categoria")
    public ProveedoresEntity RegistroCategoria() {
        return new ProveedoresEntity();
    }
    
    @PostMapping("/registroproveedores")
    public String RegistroCProductos(
            @ModelAttribute("proveedores") ProveedoresEntity c) {
        servicio.add(c);
        return "redirect:/listarproveedores?correcto";
    }
}