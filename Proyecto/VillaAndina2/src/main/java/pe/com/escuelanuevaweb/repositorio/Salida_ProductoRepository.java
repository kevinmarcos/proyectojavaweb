
package pe.com.escuelanuevaweb.repositorio;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.escuelanuevaweb.modelo.Salida_ProductoEntity;

public interface Salida_ProductoRepository extends JpaRepository<Salida_ProductoEntity, Long>{
    @Query("select s from Salida_ProductoEntity s where s.estado=1")
    List<Salida_ProductoEntity> findAllCustom();
    
    @Query("select p from Salida_ProductoEntity p where p.estado=0")
    List<Salida_ProductoEntity> findAllCustomEnable();
}
