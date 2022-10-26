
package com.villandinaweb.repository;

import com.villandinaweb.entity.DestinoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DestinoRepository extends JpaRepository<DestinoEntity, Long>{
    @Query("select c from DestinoEntity c where c.estado=1")
    List<DestinoEntity> findAllCustom();
}
