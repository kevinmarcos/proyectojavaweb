package pe.com.escuelanuevaweb.servicio;

import java.util.List;
import java.util.Optional;
import pe.com.escuelanuevaweb.modelo.CarreraEntity;


public interface CarreraService {

    //funcion para mostrar todos los datos
    List<CarreraEntity> findAll();

    //funcion para buscar por codigo
    CarreraEntity findById(Long id);

    //funcion para registrar
    CarreraEntity add(CarreraEntity c);

    //funcion para actualizar
    CarreraEntity update(CarreraEntity c);

    //funcion para eliminar
    CarreraEntity delete(CarreraEntity c);

    //funcion para mostrar datos habilitados
    List<CarreraEntity> findAllCustom();
    
     CarreraEntity enable(CarreraEntity c);
    
}
