package pe.com.escuelanuevaweb.servicio;


import java.util.List;
import java.util.Optional;
import pe.com.escuelanuevaweb.modelo.DestinoEntity;

public interface DestinoService {

    List<DestinoEntity> findAll();

    DestinoEntity findById(Long id);

    DestinoEntity add(DestinoEntity d);

    DestinoEntity update(DestinoEntity d);

    DestinoEntity delete(DestinoEntity d);

    List<DestinoEntity> findAllCustom();
    
    List<DestinoEntity> findAllCustomEnable();
    
    DestinoEntity enable(DestinoEntity p);
}
