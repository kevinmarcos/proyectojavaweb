
package com.villandinaweb.service;

import com.villandinaweb.entity.Detalle_EntradaEntity;
import java.util.List;
import java.util.Optional;

public interface Detalle_EntradaService {
    List<Detalle_EntradaEntity> findAll();

    Optional<Detalle_EntradaEntity> findById(Long id);

    Detalle_EntradaEntity add(Detalle_EntradaEntity d);

    Detalle_EntradaEntity update(Detalle_EntradaEntity d);

    Detalle_EntradaEntity delete(Detalle_EntradaEntity d);

    List<Detalle_EntradaEntity> findAllCustom();
}
