
package com.villaandina.VillaAndina.repository;

import com.villaandina.VillaAndina.entity.ProductosEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductosRepository extends JpaRepository<ProductosEntity, Long>{
    @Query("select p from ProductosEntity p where p.estado=true")
    List<ProductosEntity> findAllCustom();
}
