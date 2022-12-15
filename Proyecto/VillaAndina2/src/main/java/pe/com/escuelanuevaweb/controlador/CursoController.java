package pe.com.escuelanuevaweb.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.escuelanuevaweb.modelo.CursoEntity;
import pe.com.escuelanuevaweb.servicio.CursoService;

@Controller
public class CursoController {
    
    @Autowired
    private CursoService servicio;
    
    @GetMapping("/listarcurso")
    public String PaginaListarCurso(Model modelo) {
        modelo.addAttribute("cursos", servicio.findAllCustom());
        return "listarcurso";
    }
    
    @GetMapping("/registrocurso")
    public String MostrarFormularioRegistro() {
        //es el nombre que tendra la pagina web
        return "registrocurso";
    }
    
    @ModelAttribute("curso")
    public CursoEntity RegistroCurso() {
        return new CursoEntity();
    }
    
    @PostMapping("/registrocurso")
    public String RegistroCursoNuevo(
            @ModelAttribute("curso") CursoEntity c) {
        servicio.add(c);
        return "redirect:/listarcurso?correcto";
    }

//    @GetMapping("/actualizarcurso/{id}")
//    public String MostrarFormularioActualizar(@PathVariable Long id,
//            Model modelo) {
//        modelo.addAttribute("cursos", servicio.findById(id));
//        return "actualizacurso";
//    }
    @GetMapping("/actualizacurso/{id}")
    public String MostrarFormularioActualiza(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("cursos", servicio.findById(id));
        return "actualizacurso";
    }
    
    @PostMapping("/actualizacurso/{id}")
    public String ActualizaCurso(@PathVariable Long id,
            @ModelAttribute("curso") CursoEntity c) {
        servicio.update(c);
        return "redirect:/listarcurso?actualizo";
    }
    
    @GetMapping("/eliminacurso/{id}")
    public String EliminaCurso(@PathVariable Long id, Model modelo) {
        CursoEntity objcurso = servicio.findById(id);
        servicio.delete(objcurso);
        return "redirect:/listarcurso?elimino";
    }
    
    @GetMapping("/habilitarcurso")
    public String PaginaHabilitarCurso(Model modelo) {
        modelo.addAttribute("cursos", servicio.findAll());
        return "habilitarcurso";
    }
    
    @GetMapping("/habilitacurso/{id}")
    public String HabilitaCurso(@PathVariable Long id, Model modelo) {
        CursoEntity objcurso = servicio.findById(id);
        servicio.enable(objcurso);
        return "redirect:/listarcurso?habilito";
    }
    
}
