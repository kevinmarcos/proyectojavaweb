
package com.villaandina.VillaAndina.repository;

import com.villaandina.VillaAndina.entity.Entrada_ProductoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Entrada_ProductoRepository extends JpaRepository<Entrada_ProductoEntity, Long>{
    @Query("select e from Entrada_ProductoEntity e where e.estado=1")
    List<Entrada_ProductoEntity> findAllCustom();
}
