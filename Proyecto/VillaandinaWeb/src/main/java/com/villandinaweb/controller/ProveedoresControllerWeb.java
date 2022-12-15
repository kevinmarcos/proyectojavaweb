
package com.villandinaweb.controller;

import com.villandinaweb.entity.ProveedoresEntity;
import com.villandinaweb.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProveedoresControllerWeb {
    @Autowired
    private ProveedoresService servicio;

    @GetMapping("/listarproveedor")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("proveedores", servicio.findAllCustom());
        return "listarproveedor";
    }
 
    @GetMapping("/registroproveedor")
    public String MostrarFormularioRegistro() {
        //es el nombre que tendra la pagina web
        return "registroproveedor";
    }
    
    @ModelAttribute("proveedores")
    public ProveedoresEntity RegistroCategoria() {
        return new ProveedoresEntity();
    }
    
    @PostMapping("/registroproveedor")
    public String RegistroCProductos(
            @ModelAttribute("proveedores") ProveedoresEntity c) {
        servicio.add(c);
        return "redirect:/listarproveedor?correcto";
    }
    
    @GetMapping("/actualizarproveedor/{id}")
    public String MostrarFormularioActualiza(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("proveedores", servicio.findById(id));
        return "actualizarproveedor";
    }
    
    @PostMapping("/actualizarproveedor/{id}")
    public String ActualizaCurso(@PathVariable Long id,
            @ModelAttribute("proveedores") ProveedoresEntity c) {
        servicio.update(c);
        return "redirect:/listarproveedor?actualizo";
    }
    
    @GetMapping("/eliminaproveedor/{id}")
    public String EliminaCurso(@PathVariable Long id, Model modelo) {
        ProveedoresEntity objcurso = servicio.findById(id);
        servicio.delete(objcurso);
        return "redirect:/listarproveedor?elimino";
    }
    
    @GetMapping("/habilitarproveedor")
    public String PaginaHabilitarCurso(Model modelo) {
        modelo.addAttribute("proveedores", servicio.findAllCustomEnable());
        return "habilitarproveedor";
    }
    
    @GetMapping("/habilitaproveedor/{id}")
    public String HabilitaCurso(@PathVariable Long id, Model modelo) {
        ProveedoresEntity objcurso = servicio.findById(id);
        servicio.enable(objcurso);
        return "redirect:/habilitarproveedor?habilito";
    }
}
