
package com.villaandina.VillaAndina.repository;

import com.villaandina.VillaAndina.entity.Salida_ProductoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Salida_ProductoRepository extends JpaRepository<Salida_ProductoEntity, Long>{
    @Query("select s from Salida_ProductoEntity s where s.estado=true")
    List<Salida_ProductoEntity> findAllCustom();
}
