
package pe.com.escuelanuevaweb.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.escuelanuevaweb.modelo.ProductosEntity;
import pe.com.escuelanuevaweb.servicio.CategoriaService;
import pe.com.escuelanuevaweb.servicio.ProductosService;

@Controller
public class ProductosControllerWeb {

    @Autowired
    private ProductosService servicio;
    @Autowired
    private CategoriaService serviciocategoria;

    @GetMapping("/listarproductos")
    public String PaginaProductos(Model modelo) {
        modelo.addAttribute("productos", servicio.findAll());
        return "listarproductos";
    }
    
    @GetMapping("/registroproductos")
    public String MostrarFormularioRegistro(Model modelo) {
        //es el nombre que tendra la pagina web
        modelo.addAttribute("categoria", serviciocategoria.findAll());
        return "registroproductos";
    }
    @ModelAttribute("productos")
    public ProductosEntity RegistroProductos() {
        return new ProductosEntity();
    }
    
    @PostMapping("/registroproductos")
    public String RegistroCProductos(
            @ModelAttribute("productos") ProductosEntity c) {
        servicio.add(c);
        return "redirect:/listarproductos?correcto";
    }
    
    @GetMapping("/actualizaproducto/{id}")
    public String MostrarFormularioActualiza(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("productos", servicio.findById(id));
        modelo.addAttribute("categoria", serviciocategoria.findAll());
        return "actualizaproducto";
    }
    
    @PostMapping("/actualizaproducto/{id}")
    public String ActualizaProducto(@PathVariable Long id,
    @ModelAttribute("productos") ProductosEntity c) {
        servicio.update(c);
        return "redirect:/listarproductos?actualizo";
    }
}
