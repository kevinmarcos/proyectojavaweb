
package pe.com.escuelanuevaweb.repositorio;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.escuelanuevaweb.modelo.EmpleadoEntity;


public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long>{
    @Query("select e from EmpleadoEntity e where e.estado=1")
    List<EmpleadoEntity> findAllCustom();
    
    @Query("select p from EmpleadoEntity p where p.estado=0")
    List<EmpleadoEntity> findAllCustomEnable();
}
