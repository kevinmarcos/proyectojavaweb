
package pe.com.escuelanuevaweb.servicio;


import java.util.List;
import java.util.Optional;
import pe.com.escuelanuevaweb.modelo.ProductosEntity;

public interface ProductosService {
    List<ProductosEntity> findAll();

    ProductosEntity findById(Long id);

    ProductosEntity add(ProductosEntity p);

    ProductosEntity update(ProductosEntity p);

    ProductosEntity delete(ProductosEntity p);

    List<ProductosEntity> findAllCustom();
    
    List<ProductosEntity> findAllCustomEnable();
    
    ProductosEntity enable(ProductosEntity p);
}
