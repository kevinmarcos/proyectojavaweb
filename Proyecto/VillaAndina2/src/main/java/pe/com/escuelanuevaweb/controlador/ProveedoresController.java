
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
import pe.com.escuelanuevaweb.modelo.ProveedoresEntity;
import pe.com.escuelanuevaweb.servicio.ProveedoresService;

@RestController

@RequestMapping("/proveedores")
public class ProveedoresController {
    @Autowired
    private ProveedoresService  proveedoresservice;
    
    @GetMapping
    public List<ProveedoresEntity> findAll(){
        return proveedoresservice.findAll();
    }
    
    @GetMapping("/custom")
    public List<ProveedoresEntity> findAllCustom(){
        return proveedoresservice.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public ProveedoresEntity findById(@PathVariable Long id){
        return proveedoresservice.findById(id);
    }
    
    @PostMapping
    public ProveedoresEntity add(@RequestBody ProveedoresEntity e){
        return proveedoresservice.add(e);
    }
    
    @PutMapping("/{id}")
    public ProveedoresEntity update(@PathVariable Long id, @RequestBody ProveedoresEntity e){
        e.setCodigo(id);
        return proveedoresservice.update(e);
    }
    
    @DeleteMapping("/{id}")
    public ProveedoresEntity delete(@PathVariable Long id){
        ProveedoresEntity objcategoria = new ProveedoresEntity();
        objcategoria.setEstado(false);
        return proveedoresservice.delete(ProveedoresEntity.builder().codigo(id).build());
    }
}
