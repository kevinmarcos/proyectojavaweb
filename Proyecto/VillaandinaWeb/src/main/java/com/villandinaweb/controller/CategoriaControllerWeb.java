/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.villandinaweb.controller;

import com.villandinaweb.entity.CategoriaEntity;
import com.villandinaweb.entity.ProductosEntity;
import com.villandinaweb.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaControllerWeb {

    @Autowired
    private CategoriaService servicio;

    @GetMapping("/listarcategoria")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("categoria", servicio.findAll());
        return "listarcategoria";
    }
 
    @GetMapping("/registrocategoria")
    public String MostrarFormularioRegistro() {
        //es el nombre que tendra la pagina web
        return "registrocategoria";
    }
    
    @ModelAttribute("categoria")
    public CategoriaEntity RegistroCategoria() {
        return new CategoriaEntity();
    }
    
    @PostMapping("/registrocategoria")
    public String RegistroCProductos(
            @ModelAttribute("categoria") CategoriaEntity c) {
        servicio.add(c);
        return "redirect:/listarcategoria?correcto";
    }
}