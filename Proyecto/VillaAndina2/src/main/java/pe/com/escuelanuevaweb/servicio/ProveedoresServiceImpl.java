
package pe.com.escuelanuevaweb.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.escuelanuevaweb.modelo.ProveedoresEntity;
import pe.com.escuelanuevaweb.repositorio.ProveedoresRepository;


@Service
public class ProveedoresServiceImpl implements ProveedoresService{
    @Autowired
    private ProveedoresRepository proveedoresrepositorio;

    @Override
    public List<ProveedoresEntity> findAll() {
        return proveedoresrepositorio.findAll();
    }

    @Override
    public ProveedoresEntity findById(Long id) {
        return proveedoresrepositorio.findById(id).get();
    }

    @Override
    public ProveedoresEntity add(ProveedoresEntity p) {
        return proveedoresrepositorio.save(p);
    }

    @Override
    public ProveedoresEntity update(ProveedoresEntity p) {
        ProveedoresEntity objcarrera = proveedoresrepositorio.getById(p.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(p, objcarrera);
        return proveedoresrepositorio.save(objcarrera);
    }

    @Override
    public ProveedoresEntity delete(ProveedoresEntity p) {
        ProveedoresEntity objcarrera = proveedoresrepositorio.getById(p.getCodigo());
        objcarrera.setEstado(false);
        return proveedoresrepositorio.save(objcarrera);
    }

    @Override
    public List<ProveedoresEntity> findAllCustom() {
        return proveedoresrepositorio.findAllCustom();
    }
    
    @Override
    public List<ProveedoresEntity> findAllCustomEnable() {
        return proveedoresrepositorio.findAllCustomEnable();
    }
    
    @Override
    public ProveedoresEntity enable(ProveedoresEntity p) {
        ProveedoresEntity objcarrera = proveedoresrepositorio.getById(p.getCodigo());
        objcarrera.setEstado(true);
        return proveedoresrepositorio.save(objcarrera);
    }
}
