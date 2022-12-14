
package pe.com.escuelanuevaweb.repositorio;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.escuelanuevaweb.modelo.Detalle_EntradaEntity;

public interface Detalle_EntradaRepository extends JpaRepository<Detalle_EntradaEntity, Long>{
    @Query("select d from Detalle_EntradaEntity d where d.estado=1")
    List<Detalle_EntradaEntity> findAllCustom();
    
    @Query("select p from Detalle_EntradaEntity p where p.estado=0")
    List<Detalle_EntradaEntity> findAllCustomEnable();
}
