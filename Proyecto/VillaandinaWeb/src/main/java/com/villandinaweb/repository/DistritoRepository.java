
package com.villandinaweb.repository;


import com.villandinaweb.entity.DistritoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DistritoRepository extends JpaRepository<DistritoEntity, Long>{
    @Query("select d from DistritoEntity d where d.estado=1")
    List<DistritoEntity> findAllCustom();
}
