
package pe.com.escuelanuevaweb.repositorio;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.escuelanuevaweb.modelo.Entrada_ProductoEntity;


public interface Entrada_ProductoRepository extends JpaRepository<Entrada_ProductoEntity, Long>{
   @Query("select e from Entrada_ProductoEntity e where e.estado=1")
    List<Entrada_ProductoEntity> findAllCustom(); 
    
    @Query("select p from Entrada_ProductoEntity p where p.estado=0")
    List<Entrada_ProductoEntity> findAllCustomEnable();
}
