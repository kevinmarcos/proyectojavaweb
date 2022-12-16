package pe.com.escuelanuevaweb.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.escuelanuevaweb.servicio.Detalle_EntradaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.escuelanuevaweb.modelo.Detalle_EntradaEntity;



@Controller
public class Detalle_EntradaControllerWeb {
    @Autowired
    private Detalle_EntradaService servicio;

    @GetMapping("/listardetalle_entrada")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("detalle_entrada", servicio.findAllCustom());
        return "listardetalle_entrada";
    }
 
    @GetMapping("/registrodetalle_entrada")
    public String MostrarFormularioRegistro() {
        //es el nombre que tendra la pagina web
        return "registrodetalle_entrada";
    }
    
    @ModelAttribute("detalle_entrada")
    public Detalle_EntradaEntity RegistroCategoria() {
        return new Detalle_EntradaEntity();
    }
    
    @PostMapping("/registrodetalle_entrada")
    public String RegistroCProductos(
            @ModelAttribute("detalle_entrada") Detalle_EntradaEntity c) {
        servicio.add(c);
        return "redirect:/listardetalle_entrada?correcto";
    }

        
    @GetMapping("/actualizadetalle_entrada/{id}")
    public String MostrarFormularioActualiza(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("detalle_entrada", servicio.findById(id));
        return "actualizadetalle_entrada";
    }
    
    @PostMapping("/actualizadetalle_entrada/{id}")
    public String ActualizaCurso(@PathVariable Long id,
            @ModelAttribute("detalle_entrada") Detalle_EntradaEntity c) {
        servicio.update(c);
        return "redirect:/listardetalle_entrada?actualizo";
    }
    
    @GetMapping("/eliminadetalle_entrada/{id}")
    public String EliminaCurso(@PathVariable Long id) {
        Detalle_EntradaEntity objcurso = servicio.findById(id);
        servicio.delete(objcurso);
        return "redirect:/listardetalle_entrada?elimino";
    }
    
    
    @GetMapping("/habilitardetalle_entrada")
    public String PaginaHabilitarCurso(Model modelo) {
        modelo.addAttribute("detalle_entrada", servicio.findAllCustomEnable());
        return "habilitardetalle_entrada";
    }
    
    @GetMapping("/habilitadetalle_entrada/{id}")
    public String HabilitaCurso(@PathVariable Long id, Model modelo) {
        Detalle_EntradaEntity objcurso = servicio.findById(id);
        servicio.enable(objcurso);
        return "redirect:/habilitardetalle_entrada?habilito";
    }
}
