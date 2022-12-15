
package com.villandinaweb.service;

import com.villandinaweb.entity.ProductosEntity;
import java.util.List;
import java.util.Optional;

public interface ProductosService {
    List<ProductosEntity> findAll();

    ProductosEntity findById(Long id);

    ProductosEntity add(ProductosEntity p);

    ProductosEntity update(ProductosEntity p);

    ProductosEntity delete(ProductosEntity p);

    List<ProductosEntity> findAllCustom();
    
    List<ProductosEntity> findAllCustomEnable();
    
    ProductosEntity enable(ProductosEntity p);
}
