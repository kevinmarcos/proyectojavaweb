
package pe.com.escuelanuevaweb.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.escuelanuevaweb.modelo.DistritoEntity;
import pe.com.escuelanuevaweb.servicio.DistritoService;


@Controller
public class DistritoControllerWeb {
    @Autowired
    private DistritoService servicio;

    @GetMapping("/listardistrito")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("distrito", servicio.findAllCustom());
        return "listardistrito";
    }
 
    @GetMapping("/registrodistrito")
    public String MostrarFormularioRegistro() {
        //es el nombre que tendra la pagina web
        return "registrodistrito";
    }
    
    @ModelAttribute("distrito")
    public DistritoEntity RegistroCategoria() {
        return new DistritoEntity();
    }
    
    @PostMapping("/registrodistrito")
    public String RegistroCProductos(
            @ModelAttribute("distrito") DistritoEntity c) {
        servicio.add(c);
        return "redirect:/listardistrito?correcto";
    }
     
//            @GetMapping("/actualizadistrito")
//    public String MostrarFormularioActualiza(Model modelo) {
//        //es el nombre que tendra la pagina web
//        modelo.addAttribute("distrito", servicio.findAllCustom());
//        return "actualizadistrito";
        
    @GetMapping("/actualizadistrito/{id}")
    public String MostrarFormularioActualiza(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("distritos", servicio.findById(id));
        return "actualizadistrito";
    }
    
    @PostMapping("/actualizadistrito/{id}")
    public String ActualizaCurso(@PathVariable Long id,
            @ModelAttribute("distrito") DistritoEntity c) {
        servicio.update(c);
        return "redirect:/listardistrito?actualizo";
    }
    
    @GetMapping("/eliminadistrito/{id}")
    public String EliminaCurso(@PathVariable Long id) {
        DistritoEntity objcurso = servicio.findById(id);
        servicio.delete(objcurso);
        return "redirect:/listardistrito?elimino";
    }
    
    
    @GetMapping("/habilitardistrito")
    public String PaginaHabilitarCurso(Model modelo) {
        modelo.addAttribute("distritos", servicio.findAllCustomEnable());
        return "habilitardistrito";
    }
    
    @GetMapping("/habilitadistrito/{id}")
    public String HabilitaCurso(@PathVariable Long id, Model modelo) {
        DistritoEntity objcurso = servicio.findById(id);
        servicio.enable(objcurso);
        return "redirect:/habilitardistrito?habilito";
    }
}
