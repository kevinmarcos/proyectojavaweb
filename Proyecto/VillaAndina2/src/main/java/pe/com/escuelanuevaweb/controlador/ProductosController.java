
package pe.com.escuelanuevaweb.controlador;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.escuelanuevaweb.modelo.ProductosEntity;
import pe.com.escuelanuevaweb.servicio.ProductosService;

@RestController

@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private ProductosService  productosservice;
    
    @GetMapping
    public List<ProductosEntity> findAll(){
        return productosservice.findAll();
    }
    
    @GetMapping("/custom")
    public List<ProductosEntity> findAllCustom(){
        return productosservice.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public ProductosEntity findById(@PathVariable Long id){
        return productosservice.findById(id);
    }
    
    @PostMapping
    public ProductosEntity add(@RequestBody ProductosEntity e){
        return productosservice.add(e);
    }
    
    @PutMapping("/{id}")
    public ProductosEntity update(@PathVariable Long id, @RequestBody ProductosEntity e){
        e.setCodigo(id);
        return productosservice.update(e);
    }
    
    @DeleteMapping ("/{id}")
    public ProductosEntity delete(@PathVariable Long id){
        ProductosEntity objproducto = new ProductosEntity();
        objproducto.setEstado(false);
        return productosservice.delete(ProductosEntity.builder().codigo(id).build());
    }
}
