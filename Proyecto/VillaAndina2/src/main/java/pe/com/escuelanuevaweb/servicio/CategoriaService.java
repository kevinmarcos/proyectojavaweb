package pe.com.escuelanuevaweb.servicio;


import java.util.List;
import java.util.Optional;
import pe.com.escuelanuevaweb.modelo.CategoriaEntity;

public interface CategoriaService {

    List<CategoriaEntity> findAll();

    CategoriaEntity findById(Long id);

    CategoriaEntity add(CategoriaEntity c);

    CategoriaEntity update(CategoriaEntity c);

    CategoriaEntity delete(CategoriaEntity c);

    List<CategoriaEntity> findAllCustom();
    
    List<CategoriaEntity> findAllCustomEnable();
    
    CategoriaEntity enable(CategoriaEntity p);
}
