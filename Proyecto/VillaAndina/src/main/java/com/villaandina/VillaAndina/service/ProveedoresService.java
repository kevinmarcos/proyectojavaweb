
package com.villaandina.VillaAndina.service;

import com.villaandina.VillaAndina.entity.ProveedoresEntity;
import java.util.List;
import java.util.Optional;

public interface ProveedoresService {
    //Funcion para mostrar todos los datos
    List<ProveedoresEntity> findAll();
    
    //Funcion para buscar por codigo
    Optional<ProveedoresEntity> findById(Long id);
    
    //Funcion para registrar
    ProveedoresEntity add(ProveedoresEntity p);
    
    //Funcion para actualizar
    ProveedoresEntity update(ProveedoresEntity p);
    
    //Funcion para eliminar
    ProveedoresEntity delete(ProveedoresEntity p);
    
    //Funcion para mostrar datos habilitados
    List<ProveedoresEntity> findAllCustom();
}
