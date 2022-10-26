
package com.villaandina.VillaAndina.service;

import com.villaandina.VillaAndina.entity.EmpleadoEntity;
import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    //Funcion para mostrar todos los datos
    List<EmpleadoEntity> findAll();
    
    //Funcion para buscar por codigo
    Optional<EmpleadoEntity> findById(Long id);
    
    //Funcion para registrar
    EmpleadoEntity add(EmpleadoEntity e);
    
    //Funcion para actualizar
    EmpleadoEntity update(EmpleadoEntity e);
    
    //Funcion para eliminar
    EmpleadoEntity delete(EmpleadoEntity e);
    
    //Funcion para mostrar datos habilitados
    List<EmpleadoEntity> findAllCustom(); 
}
