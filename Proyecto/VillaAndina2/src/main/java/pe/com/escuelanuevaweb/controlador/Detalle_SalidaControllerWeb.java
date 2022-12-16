package pe.com.escuelanuevaweb.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.escuelanuevaweb.modelo.Detalle_SalidaEntity;
import pe.com.escuelanuevaweb.servicio.Detalle_SalidaService;


@Controller
public class Detalle_SalidaControllerWeb {
    @Autowired
    private Detalle_SalidaService servicio;

    @GetMapping("/listardetalle_salida")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("detalle_salida", servicio.findAllCustom());
        return "listardetalle_salida";
    }
 
    @GetMapping("/registrodetalle_salida")
    public String MostrarFormularioRegistro() {
        //es el nombre que tendra la pagina web
        return "registrodetalle_salida";
    }
    
    @ModelAttribute("detalle_salida")
    public Detalle_SalidaEntity RegistroCategoria() {
        return new Detalle_SalidaEntity();
    }
    
    @PostMapping("/registrodetalle_salida")
    public String RegistroCProductos(
            @ModelAttribute("detalle_salida") Detalle_SalidaEntity c) {
        servicio.add(c);
        return "redirect:/listardetalle_salida?correcto";
    }

        
    @GetMapping("/actualizadetalle_salida/{id}")
    public String MostrarFormularioActualiza(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("detalle_salida", servicio.findById(id));
        return "actualizadetalle_salida";
    }
    
    @PostMapping("/actualizadetalle_salida/{id}")
    public String ActualizaCurso(@PathVariable Long id,
            @ModelAttribute("detalle_salida") Detalle_SalidaEntity c) {
        servicio.update(c);
        return "redirect:/listardetalle_salida?actualizo";
    }
    
    @GetMapping("/eliminadetalle_salida/{id}")
    public String EliminaCurso(@PathVariable Long id) {
        Detalle_SalidaEntity objcurso = servicio.findById(id);
        servicio.delete(objcurso);
        return "redirect:/listardetalle_salida?elimino";
    }
    
    
    @GetMapping("/habilitardetalle_salida")
    public String PaginaHabilitarCurso(Model modelo) {
        modelo.addAttribute("detalle_salida", servicio.findAllCustomEnable());
        return "habilitardetalle_salida";
    }
    
    @GetMapping("/habilitadetalle_salida/{id}")
    public String HabilitaCurso(@PathVariable Long id, Model modelo) {
        Detalle_SalidaEntity objcurso = servicio.findById(id);
        servicio.enable(objcurso);
        return "redirect:/habilitardetalle_salida?habilito";
    }
}
