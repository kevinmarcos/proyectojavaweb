
package com.villaandina.VillaAndina.repository;

import com.villaandina.VillaAndina.entity.CategoriaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    @Query("select c from CategoriaEntity c")
    List<CategoriaEntity> findAllCustom();
}
