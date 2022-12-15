
package com.villandinaweb.service;

import com.villandinaweb.entity.EmpleadoEntity;
import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<EmpleadoEntity> findAll();

    EmpleadoEntity findById(Long id);

    EmpleadoEntity add(EmpleadoEntity e);

    EmpleadoEntity update(EmpleadoEntity e);

    EmpleadoEntity delete(EmpleadoEntity e);

    List<EmpleadoEntity> findAllCustom();
    
    List<EmpleadoEntity> findAllCustomEnable();
    
    EmpleadoEntity enable(EmpleadoEntity p);
}
