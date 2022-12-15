
package pe.com.escuelanuevaweb.servicio;

import java.util.List;
import java.util.Optional;
import pe.com.escuelanuevaweb.modelo.DistritoEntity;

public interface DistritoService {
    List<DistritoEntity> findAll();

    DistritoEntity findById(Long id);

    DistritoEntity add(DistritoEntity d);

    DistritoEntity update(DistritoEntity d);

    DistritoEntity delete(DistritoEntity d);

    List<DistritoEntity> findAllCustom();
    
    List<DistritoEntity> findAllCustomEnable();
    
    DistritoEntity enable(DistritoEntity p);
}
