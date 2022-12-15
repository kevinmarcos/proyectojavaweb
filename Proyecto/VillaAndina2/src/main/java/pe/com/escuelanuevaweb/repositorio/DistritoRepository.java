
package pe.com.escuelanuevaweb.repositorio;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.escuelanuevaweb.modelo.DistritoEntity;

public interface DistritoRepository extends JpaRepository<DistritoEntity, Long>{
    @Query("select d from DistritoEntity d where d.estado=1")
    List<DistritoEntity> findAllCustom();
    
    @Query("select p from DistritoEntity p where p.estado=0")
    List<DistritoEntity> findAllCustomEnable();
}
