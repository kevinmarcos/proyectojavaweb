package pe.com.escuelanuevaweb.servicio;

import java.util.List;
import pe.com.escuelanuevaweb.modelo.CursoEntity;

public interface CursoService {

    //funcion para mostrar todos los datos
    List<CursoEntity> findAll();

    //funcion para buscar por codigo
    CursoEntity findById(Long id);

    //funcion para registrar
    CursoEntity add(CursoEntity c);

    //funcion para actualizar
    CursoEntity update(CursoEntity c);

    //funcion para eliminar
    CursoEntity delete(CursoEntity c);

    //funcion para mostrar datos habilitados
    List<CursoEntity> findAllCustom();

    CursoEntity enable(CursoEntity c);
}
