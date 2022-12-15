
package com.villandinaweb.repository;

import com.villandinaweb.entity.EmpleadoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long>{
    @Query("select e from EmpleadoEntity e where e.estado=1")
    List<EmpleadoEntity> findAllCustom();
    
    @Query("select p from EmpleadoEntity p where p.estado=0")
    List<EmpleadoEntity> findAllCustomEnable();
}
