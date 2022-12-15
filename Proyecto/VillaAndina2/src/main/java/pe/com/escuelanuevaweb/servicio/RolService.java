package pe.com.escuelanuevaweb.servicio;

import java.util.List;
import java.util.Optional;
import pe.com.escuelanuevaweb.modelo.RolEntity;
import pe.com.escuelanuevaweb.repositorio.RolRepository;

public interface RolService {

    List<RolEntity> findAll();

    Optional<RolEntity> findById(Long id);

    RolEntity add(RolEntity r);

    RolEntity update(RolEntity r);

    RolEntity delete(RolEntity r);

    List<RolEntity> findAllCustom();
}
