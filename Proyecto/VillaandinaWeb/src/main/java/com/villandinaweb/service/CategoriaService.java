package com.villandinaweb.service;

import com.villandinaweb.entity.CategoriaEntity;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<CategoriaEntity> findAll();

    CategoriaEntity findById(Long id);

    CategoriaEntity add(CategoriaEntity c);

    CategoriaEntity update(CategoriaEntity c);

    CategoriaEntity delete(CategoriaEntity c);

    List<CategoriaEntity> findAllCustom();
    
    List<CategoriaEntity> findAllCustomEnable();
    
    CategoriaEntity enable(CategoriaEntity p);
}
