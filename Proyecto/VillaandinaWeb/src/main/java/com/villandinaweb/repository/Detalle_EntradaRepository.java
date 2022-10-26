
package com.villandinaweb.repository;


import com.villandinaweb.entity.Detalle_EntradaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Detalle_EntradaRepository extends JpaRepository<Detalle_EntradaEntity, Long>{
    @Query("select d from Detalle_EntradaEntity d where d.estado=1")
    List<Detalle_EntradaEntity> findAllCustom();
}
