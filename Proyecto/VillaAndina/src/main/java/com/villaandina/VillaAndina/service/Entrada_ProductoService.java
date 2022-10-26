
package com.villaandina.VillaAndina.service;

import com.villaandina.VillaAndina.entity.Entrada_ProductoEntity;
import java.util.List;
import java.util.Optional;

public interface Entrada_ProductoService {
    //Funcion para mostrar todos los datos
    List<Entrada_ProductoEntity> findAll();
    
    //Funcion para buscar por codigo
    Optional<Entrada_ProductoEntity> findById(Long id);
    
    //Funcion para registrar
    Entrada_ProductoEntity add(Entrada_ProductoEntity e);
    
    //Funcion para actualizar
    Entrada_ProductoEntity update(Entrada_ProductoEntity e);
    
    //Funcion para eliminar
    Entrada_ProductoEntity delete(Entrada_ProductoEntity e);
    
    //Funcion para mostrar datos habilitados
    List<Entrada_ProductoEntity> findAllCustom();
}
