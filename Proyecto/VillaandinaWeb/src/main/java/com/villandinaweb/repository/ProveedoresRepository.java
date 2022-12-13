
package com.villandinaweb.repository;


import com.villandinaweb.entity.ProveedoresEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProveedoresRepository extends JpaRepository<ProveedoresEntity, Long>{
    @Query("select p from ProveedoresEntity p where p.estado=1")
    List<ProveedoresEntity> findAllCustom();
    
    @Query("select p from ProveedoresEntity p where p.estado=0")
    List<ProveedoresEntity> findAllCustomEnable();
}
