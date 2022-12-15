/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.escuelanuevaweb.repositorio;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.escuelanuevaweb.modelo.Detalle_SalidaEntity;

public interface Detalle_SalidaRepository extends JpaRepository<Detalle_SalidaEntity, Long>{
    @Query("select d from Detalle_SalidaEntity d where d.estado=1")
    List<Detalle_SalidaEntity> findAllCustom();
    
    @Query("select p from Detalle_SalidaEntity p where p.estado=0")
    List<Detalle_SalidaEntity> findAllCustomEnable();
}
