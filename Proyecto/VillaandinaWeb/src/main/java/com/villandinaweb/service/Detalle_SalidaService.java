
package com.villandinaweb.service;

import com.villandinaweb.entity.Detalle_SalidaEntity;
import java.util.List;
import java.util.Optional;

public interface Detalle_SalidaService {
    List<Detalle_SalidaEntity> findAll();

    Optional<Detalle_SalidaEntity> findById(Long id);

    Detalle_SalidaEntity add(Detalle_SalidaEntity d);

    Detalle_SalidaEntity update(Detalle_SalidaEntity d);

    Detalle_SalidaEntity delete(Detalle_SalidaEntity d);

    List<Detalle_SalidaEntity> findAllCustom();
}
