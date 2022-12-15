
package pe.com.escuelanuevaweb.servicio;


import java.util.List;
import java.util.Optional;
import pe.com.escuelanuevaweb.modelo.Entrada_ProductoEntity;

public interface Entrada_ProductoService {
    List<Entrada_ProductoEntity> findAll();

    Entrada_ProductoEntity findById(Long id);

    Entrada_ProductoEntity add(Entrada_ProductoEntity e);

    Entrada_ProductoEntity update(Entrada_ProductoEntity e);

    Entrada_ProductoEntity delete(Entrada_ProductoEntity e);

    List<Entrada_ProductoEntity> findAllCustom();
    
    List<Entrada_ProductoEntity> findAllCustomEnable();
    
    Entrada_ProductoEntity enable(Entrada_ProductoEntity p);
}
