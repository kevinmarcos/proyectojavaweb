
package com.villaandina.VillaAndina.service;

import com.villaandina.VillaAndina.entity.DistritoEntity;
import java.util.List;
import java.util.Optional;

public interface DistritoService {
    //Funcion para mostrar todos los datos
    List<DistritoEntity> findAll();
    
    //Funcion para buscar por codigo
    Optional<DistritoEntity> findById(Long id);
    
    //Funcion para registrar
    DistritoEntity add(DistritoEntity d);
    
    //Funcion para actualizar
    DistritoEntity update(DistritoEntity d);
    
    //Funcion para eliminar
    DistritoEntity delete(DistritoEntity d);
    
    //Funcion para mostrar datos habilitados
    List<DistritoEntity> findAllCustom(); 
}
