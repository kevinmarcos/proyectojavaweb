/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.villaandina.VillaAndina.service;

import com.villaandina.VillaAndina.entity.CategoriaEntity;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author 51958
 */
public interface CategoriaService {
    //Funcion para mostrar todos los datos
    List<CategoriaEntity> findAll();
    
    //Funcion para buscar por codigo
    Optional<CategoriaEntity> findById(Long id);
    
    //Funcion para registrar
    CategoriaEntity add(CategoriaEntity c);
    
    //Funcion para actualizar
    CategoriaEntity update(CategoriaEntity c);
    
    //Funcion para eliminar
    CategoriaEntity delete(CategoriaEntity c);
    
    //Funcion para mostrar datos habilitados
    List<CategoriaEntity> findAllCustom(); 
}
