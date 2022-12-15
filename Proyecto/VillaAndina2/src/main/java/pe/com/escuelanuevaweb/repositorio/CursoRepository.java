
package pe.com.escuelanuevaweb.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.escuelanuevaweb.modelo.CursoEntity;



public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
    //creamos una funcion para mostrar todos los datos habilitados
    //select * from Curso where estcur=1 --> MySQL
    //select variable from Entidad variable -->JPQL
    //select c from CursoEntity c where c.estado=1
    @Query("select c from CursoEntity c where c.estado=1")
    List<CursoEntity> findAllCustom();
}
