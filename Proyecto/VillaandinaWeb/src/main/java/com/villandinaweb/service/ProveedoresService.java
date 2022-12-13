
package com.villandinaweb.service;

import com.villandinaweb.entity.ProveedoresEntity;
import java.util.List;
import java.util.Optional;

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
