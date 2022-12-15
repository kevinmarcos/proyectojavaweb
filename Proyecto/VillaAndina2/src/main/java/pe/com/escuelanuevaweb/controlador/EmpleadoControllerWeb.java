/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.escuelanuevaweb.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.escuelanuevaweb.modelo.EmpleadoEntity;
import pe.com.escuelanuevaweb.servicio.DistritoService;
import pe.com.escuelanuevaweb.servicio.EmpleadoService;


@Controller
public class EmpleadoControllerWeb {

    @Autowired
    private EmpleadoService servicio;

    @Autowired
    private DistritoService serviciodistrito;
        
    @GetMapping("/listarempleado")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("empleado", servicio.findAllCustom());
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
    
    @GetMapping("/eliminaempleado/{id}")
    public String EliminaCurso(@PathVariable Long id) {
        EmpleadoEntity objcurso = servicio.findById(id);
        servicio.delete(objcurso);
        return "redirect:/listarempleado?elimino";
    }
    
    
    @GetMapping("/habilitarempleado")
    public String PaginaHabilitarCurso(Model modelo) {
        modelo.addAttribute("empleado", servicio.findAllCustomEnable());
        return "habilitarempleado";
    }
    
    @GetMapping("/habilitaempleado/{id}")
    public String HabilitaCurso(@PathVariable Long id, Model modelo) {
        EmpleadoEntity objcurso = servicio.findById(id);
        servicio.enable(objcurso);
        return "redirect:/habilitarempleado?habilito";
    }
}

