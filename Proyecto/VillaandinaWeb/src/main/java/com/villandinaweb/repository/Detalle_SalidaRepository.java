/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.villandinaweb.repository;


import com.villandinaweb.entity.Detalle_SalidaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Detalle_SalidaRepository extends JpaRepository<Detalle_SalidaEntity, Long>{
    @Query("select d from Detalle_SalidaEntity d where d.estado=1")
    List<Detalle_SalidaEntity> findAllCustom();
}