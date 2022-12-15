
package pe.com.escuelanuevaweb.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.escuelanuevaweb.modelo.Entrada_ProductoEntity;
import pe.com.escuelanuevaweb.servicio.DestinoService;
import pe.com.escuelanuevaweb.servicio.EmpleadoService;
import pe.com.escuelanuevaweb.servicio.Entrada_ProductoService;

@Controller
public class Entrada_ProductoControllerWeb {
    @Autowired
    private Entrada_ProductoService servicio;
    
    @Autowired
    private EmpleadoService servicioempleado;
    
    @Autowired
    private DestinoService serviciodestino;

    @GetMapping("/listarentradaproducto")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("entradaproducto", servicio.findAll());
        return "listarentradaproducto";
    }
    
    @GetMapping("/registroentradaproducto")
    public String MostrarFormularioRegistro(Model modelo) {
        //es el nombre que tendra la pagina web
        modelo.addAttribute("empleado", servicioempleado.findAll());
        modelo.addAttribute("destino", serviciodestino.findAll());
        return "registroentradaproducto";
    }
    @ModelAttribute("entradaproducto")
    public Entrada_ProductoEntity RegistroProductos() {
        return new Entrada_ProductoEntity();
    }
    
    @PostMapping("/registroentradaproducto")
    public String RegistroCProductos(
            @ModelAttribute("entradaproducto") Entrada_ProductoEntity c) {
        servicio.add(c);
        return "redirect:/listarentradaproducto?correcto";
    }
}
