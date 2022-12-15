
package pe.com.escuelanuevaweb.servicio;


import java.util.List;
import java.util.Optional;
import pe.com.escuelanuevaweb.modelo.ProveedoresEntity;

public interface ProveedoresService {
    List<ProveedoresEntity> findAll();

    ProveedoresEntity findById(Long id);

    ProveedoresEntity add(ProveedoresEntity p);

    ProveedoresEntity update(ProveedoresEntity p);

    ProveedoresEntity delete(ProveedoresEntity p);

    List<ProveedoresEntity> findAllCustom();
    
    List<ProveedoresEntity> findAllCustomEnable();
    
    ProveedoresEntity enable(ProveedoresEntity p);
}
