
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
import pe.com.escuelanuevaweb.modelo.DestinoEntity;
import pe.com.escuelanuevaweb.servicio.DestinoService;

@RestController

@RequestMapping("/destino")
public class DestinoController {
    @Autowired
    private DestinoService  destinoservice;
    
    @GetMapping
    public List<DestinoEntity> findAll(){
        return destinoservice.findAll();
    }
    
    @GetMapping("/custom")
    public List<DestinoEntity> findAllCustom(){
        return destinoservice.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public DestinoEntity findById(@PathVariable Long id){
        return destinoservice.findById(id);
    }
    
    @PostMapping
    public DestinoEntity add(@RequestBody DestinoEntity e){
        return destinoservice.add(e);
    }
    
    @PutMapping("/{id}")
    public DestinoEntity update(@PathVariable Long id, @RequestBody DestinoEntity e){
        e.setCodigo(id);
        return destinoservice.update(e);
    }
    
    @DeleteMapping ("/{id}")
    public DestinoEntity delete(@PathVariable Long id){
        DestinoEntity objcategoria = new DestinoEntity();
        objcategoria.setEstado(false);
        return destinoservice.delete(DestinoEntity.builder().codigo(id).build());
    }
}
