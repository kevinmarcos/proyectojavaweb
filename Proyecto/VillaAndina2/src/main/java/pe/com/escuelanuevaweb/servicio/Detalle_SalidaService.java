
package pe.com.escuelanuevaweb.servicio;


import java.util.List;
import java.util.Optional;
import pe.com.escuelanuevaweb.modelo.Detalle_SalidaEntity;

public interface Detalle_SalidaService {
    List<Detalle_SalidaEntity> findAll();

    Detalle_SalidaEntity findById(Long id);

    Detalle_SalidaEntity add(Detalle_SalidaEntity d);

    Detalle_SalidaEntity update(Detalle_SalidaEntity d);

    Detalle_SalidaEntity delete(Detalle_SalidaEntity d);

    List<Detalle_SalidaEntity> findAllCustom();
    
    List<Detalle_SalidaEntity> findAllCustomEnable();
    
    Detalle_SalidaEntity enable(Detalle_SalidaEntity p);
}
