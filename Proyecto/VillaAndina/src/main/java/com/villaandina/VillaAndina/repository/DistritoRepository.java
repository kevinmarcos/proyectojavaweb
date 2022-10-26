
package com.villaandina.VillaAndina.repository;

import com.villaandina.VillaAndina.entity.DistritoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DistritoRepository extends JpaRepository<DistritoEntity, Long>{
    @Query("select d from DistritoEntity d")
    List<DistritoEntity> findAllCustom();
}
