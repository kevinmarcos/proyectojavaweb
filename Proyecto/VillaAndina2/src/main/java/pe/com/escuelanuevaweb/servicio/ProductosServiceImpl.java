
package pe.com.escuelanuevaweb.servicio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.escuelanuevaweb.modelo.ProductosEntity;
import pe.com.escuelanuevaweb.repositorio.ProductosRepository;


@Service
public class ProductosServiceImpl implements ProductosService{
    @Autowired
    private ProductosRepository productosrepositorio;

    @Override
    public List<ProductosEntity> findAll() {
        return productosrepositorio.findAll();
    }

    @Override
    public ProductosEntity findById(Long id) {
        return productosrepositorio.findById(id).get();
    }

    @Override
    public ProductosEntity add(ProductosEntity p) {
        return productosrepositorio.save(p);
    }

    @Override
    public ProductosEntity update(ProductosEntity p) {
        ProductosEntity objcarrera = productosrepositorio.getById(p.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(p, objcarrera);
        return productosrepositorio.save(objcarrera);
    }

    @Override
    public ProductosEntity delete(ProductosEntity p) {
        ProductosEntity objcarrera = productosrepositorio.getById(p.getCodigo());
        objcarrera.setEstado(false);
        return productosrepositorio.save(objcarrera);
    }

    @Override
    public List<ProductosEntity> findAllCustom() {
        return productosrepositorio.findAllCustom();
    }
    
    @Override
    public List<ProductosEntity> findAllCustomEnable() {
        return productosrepositorio.findAllCustomEnable();
    }
    
    @Override
    public ProductosEntity enable(ProductosEntity p) {
        ProductosEntity objcarrera = productosrepositorio.getById(p.getCodigo());
        objcarrera.setEstado(true);
        return productosrepositorio.save(objcarrera);
    }
}
