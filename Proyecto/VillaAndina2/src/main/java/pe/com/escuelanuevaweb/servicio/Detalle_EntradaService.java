
package pe.com.escuelanuevaweb.servicio;


import java.util.List;
import java.util.Optional;
import pe.com.escuelanuevaweb.modelo.Detalle_EntradaEntity;

public interface Detalle_EntradaService {
    List<Detalle_EntradaEntity> findAll();

    Detalle_EntradaEntity findById(Long id);

    Detalle_EntradaEntity add(Detalle_EntradaEntity d);

    Detalle_EntradaEntity update(Detalle_EntradaEntity d);

    Detalle_EntradaEntity delete(Detalle_EntradaEntity d);

    List<Detalle_EntradaEntity> findAllCustom();
    
    List<Detalle_EntradaEntity> findAllCustomEnable();
    
    Detalle_EntradaEntity enable(Detalle_EntradaEntity p);
}
