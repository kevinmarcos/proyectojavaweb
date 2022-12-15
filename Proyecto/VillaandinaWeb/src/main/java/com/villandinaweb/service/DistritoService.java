
package com.villandinaweb.service;

import com.villandinaweb.entity.DistritoEntity;
import java.util.List;
import java.util.Optional;

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
