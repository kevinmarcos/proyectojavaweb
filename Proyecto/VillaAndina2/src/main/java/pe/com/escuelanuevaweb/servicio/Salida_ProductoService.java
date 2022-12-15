
package pe.com.escuelanuevaweb.servicio;

import java.util.List;
import java.util.Optional;
import pe.com.escuelanuevaweb.modelo.Salida_ProductoEntity;

public interface Salida_ProductoService {
    List<Salida_ProductoEntity> findAll();

    Salida_ProductoEntity findById(Long id);

    Salida_ProductoEntity add(Salida_ProductoEntity s);

    Salida_ProductoEntity update(Salida_ProductoEntity s);

    Salida_ProductoEntity delete(Salida_ProductoEntity s);

    List<Salida_ProductoEntity> findAllCustom();
    
    List<Salida_ProductoEntity> findAllCustomEnable();
    
    Salida_ProductoEntity enable(Salida_ProductoEntity p);
}
