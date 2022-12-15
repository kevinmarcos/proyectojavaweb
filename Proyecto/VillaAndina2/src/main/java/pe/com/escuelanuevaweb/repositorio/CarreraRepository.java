
package pe.com.escuelanuevaweb.repositorio;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.escuelanuevaweb.modelo.CarreraEntity;


public interface CarreraRepository extends JpaRepository<CarreraEntity, Long> {
    @Query("select c from CarreraEntity c where c.estado=1")
    List<CarreraEntity> findAllCustom();
}
