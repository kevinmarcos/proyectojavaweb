package pe.com.escuelanuevaweb.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.escuelanuevaweb.modelo.CarreraEntity;
import pe.com.escuelanuevaweb.servicio.CarreraService;
import pe.com.escuelanuevaweb.servicio.CursoService;

@Controller
public class CarreraController {

    @Autowired
    private CarreraService servicio;
    @Autowired
    private CursoService serviciocurso;

    @GetMapping("/listarcarrera")
    public String PaginaListarCarrera(Model modelo) {
        modelo.addAttribute("carreras", servicio.findAllCustom());
        return "listarcarrera";
    }

    @GetMapping("/registrocarrera")
    public String MostrarFormularioRegistro(Model modelo) {
        //es el nombre que tendra la pagina web
        modelo.addAttribute("cursos", serviciocurso.findAll());
        return "registrocarrera";
    }

    @ModelAttribute("carrera")
    public CarreraEntity RegistroCarrera() {
        return new CarreraEntity();
    }

    @PostMapping("/registrocarrera")
    public String RegistroCarreraNuevo(
            @ModelAttribute("carrera") CarreraEntity c) {
        servicio.add(c);
        return "redirect:/listarcarrera?correcto";
    }

    @GetMapping("/actualizacarrera/{id}")
    public String MostrarFormularioActualiza(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("cursos", serviciocurso.findAll());
        modelo.addAttribute("carreras", servicio.findById(id));
        return "actualizacarrera";
    }

    @PostMapping("/actualizacarrera/{id}")
    public String ActualizaCurso(@PathVariable Long id,
            @ModelAttribute("carrera") CarreraEntity c) {
        servicio.update(c);
        return "redirect:/listarcarrera?actualizo";
    }

    @GetMapping("/eliminacarrera/{id}")
    public String EliminaCurso(@PathVariable Long id, Model modelo) {
        CarreraEntity objcurso = servicio.findById(id);
        servicio.delete(objcurso);
        return "redirect:/listarcarrera?elimino";
    }

    @GetMapping("/habilitarcarrera")
    public String PaginaHabilitarCarrera(Model modelo) {
        modelo.addAttribute("carreras", servicio.findAll());
        return "habilitarcarrera";
    }

    @GetMapping("/habilitacarrera/{id}")
    public String HabilitaCurso(@PathVariable Long id, Model modelo) {
        CarreraEntity objcurso = servicio.findById(id);
        servicio.enable(objcurso);
        return "redirect:/listarcarrera?habilito";
    }
}
