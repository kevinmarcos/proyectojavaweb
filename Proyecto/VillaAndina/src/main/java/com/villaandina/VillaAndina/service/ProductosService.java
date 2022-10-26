
package com.villaandina.VillaAndina.service;

import com.villaandina.VillaAndina.entity.ProductosEntity;
import java.util.List;
import java.util.Optional;

public interface ProductosService {
    //Funcion para mostrar todos los datos
    List<ProductosEntity> findAll();
    
    //Funcion para buscar por codigo
    Optional<ProductosEntity> findById(Long id);
    
    //Funcion para registrar
    ProductosEntity add(ProductosEntity p);
    
    //Funcion para actualizar
    ProductosEntity update(ProductosEntity p);
    
    //Funcion para eliminar
    ProductosEntity delete(ProductosEntity p);
    
    //Funcion para mostrar datos habilitados
    List<ProductosEntity> findAllCustom();
}
