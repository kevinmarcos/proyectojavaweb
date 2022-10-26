
package com.villandinaweb.service;

import com.villandinaweb.entity.Entrada_ProductoEntity;
import java.util.List;
import java.util.Optional;

public interface Entrada_ProductoService {
    List<Entrada_ProductoEntity> findAll();

    Optional<Entrada_ProductoEntity> findById(Long id);

    Entrada_ProductoEntity add(Entrada_ProductoEntity e);

    Entrada_ProductoEntity update(Entrada_ProductoEntity e);

    Entrada_ProductoEntity delete(Entrada_ProductoEntity e);

    List<Entrada_ProductoEntity> findAllCustom();
}
