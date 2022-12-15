
package com.villandinaweb.repository;


import com.villandinaweb.entity.ProductosEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductosRepository extends JpaRepository<ProductosEntity, Long>{
    @Query("select p from ProductosEntity p where p.estado=1")
    List<ProductosEntity> findAllCustom();
    
    @Query("select p from ProductosEntity p where p.estado=0")
    List<ProductosEntity> findAllCustomEnable();
}
