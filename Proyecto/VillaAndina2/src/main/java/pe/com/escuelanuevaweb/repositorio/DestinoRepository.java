
package pe.com.escuelanuevaweb.repositorio;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.escuelanuevaweb.modelo.DestinoEntity;

public interface DestinoRepository extends JpaRepository<DestinoEntity, Long>{
    @Query("select c from DestinoEntity c where c.estado=1")
    List<DestinoEntity> findAllCustom();
    
    @Query("select p from DestinoEntity p where p.estado=0")
    List<DestinoEntity> findAllCustomEnable();
}
