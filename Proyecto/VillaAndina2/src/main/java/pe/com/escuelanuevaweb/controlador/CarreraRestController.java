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
import pe.com.escuelanuevaweb.modelo.CarreraEntity;
import pe.com.escuelanuevaweb.servicio.CarreraService;

//@RestController define la clase como un controlador
@RestController
//@RequestMapping("/carrera") define el nombre del controlador
@RequestMapping("/carrera")
public class CarreraRestController {
   @Autowired
    private CarreraService carreraservice;

    //@GetMapping sirve para obtener valores
    @GetMapping
    public List<CarreraEntity> findAll() {
        return carreraservice.findAll();
    }

    @GetMapping("/custom")
    public List<CarreraEntity> findAllCustom() {
        return carreraservice.findAllCustom();
    }

    @GetMapping("/{id}")
    public CarreraEntity findById(@PathVariable Long id) {
        return carreraservice.findById(id);
    }

    //@PostMapping permite enviar(registrar) valores
    @PostMapping
    public CarreraEntity add(@RequestBody CarreraEntity c) {
        return carreraservice.add(c);
    }

    //@PutMapping permite actualizar
    @PutMapping("/{id}")
    public CarreraEntity update(@PathVariable Long id, @RequestBody CarreraEntity c) {
        c.setCodigo(id);
        return carreraservice.update(c);
    }

    //@DeleteMapping permite eliminar un valor
    @DeleteMapping("/{id}")
    public CarreraEntity delete(@PathVariable Long id) {
        //c.setCodigo(id);
        //return carreraservice.delete(c);
        CarreraEntity objcategoria = new CarreraEntity();
        objcategoria.setEstado(false);
        return carreraservice.delete(CarreraEntity.builder().codigo(id).build());
    }  
}
