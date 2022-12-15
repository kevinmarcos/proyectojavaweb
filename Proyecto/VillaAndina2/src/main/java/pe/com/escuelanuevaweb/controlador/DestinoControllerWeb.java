
package pe.com.escuelanuevaweb.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.escuelanuevaweb.modelo.DestinoEntity;
import pe.com.escuelanuevaweb.servicio.DestinoService;
import pe.com.escuelanuevaweb.servicio.DistritoService;


@Controller
public class DestinoControllerWeb {
    @Autowired
    private DestinoService servicio;
    
    @Autowired
    private DistritoService serviciodistrito;

    @GetMapping("/listardestino")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("destino", servicio.findAllCustom());
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
    
    @GetMapping("/eliminadestino/{id}")
    public String EliminaCurso(@PathVariable Long id) {
        DestinoEntity objcurso = servicio.findById(id);
        servicio.delete(objcurso);
        return "redirect:/listardestino?elimino";
    }
    
    
    @GetMapping("/habilitardestino")
    public String PaginaHabilitarCurso(Model modelo) {
        modelo.addAttribute("destino", servicio.findAllCustomEnable());
        return "habilitardestino";
    }
    
    @GetMapping("/habilitadestino/{id}")
    public String HabilitaCurso(@PathVariable Long id, Model modelo) {
        DestinoEntity objcurso = servicio.findById(id);
        servicio.enable(objcurso);
        return "redirect:/habilitardestino?habilito";
    }
}

