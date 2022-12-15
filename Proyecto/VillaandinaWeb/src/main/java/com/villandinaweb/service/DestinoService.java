package com.villandinaweb.service;

import com.villandinaweb.entity.DestinoEntity;
import java.util.List;
import java.util.Optional;

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
