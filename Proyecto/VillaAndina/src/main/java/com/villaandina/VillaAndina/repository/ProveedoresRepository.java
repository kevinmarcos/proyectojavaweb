
package com.villaandina.VillaAndina.repository;

import com.villaandina.VillaAndina.entity.ProveedoresEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProveedoresRepository extends JpaRepository<ProveedoresEntity, Long>{
    @Query("select p from ProveedoresEntity p ")
    List<ProveedoresEntity> findAllCustom();
}
