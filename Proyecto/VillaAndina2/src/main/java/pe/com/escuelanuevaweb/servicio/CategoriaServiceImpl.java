package pe.com.escuelanuevaweb.servicio;


import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.escuelanuevaweb.modelo.CategoriaEntity;
import pe.com.escuelanuevaweb.repositorio.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriapositorio;

    @Override
    public List<CategoriaEntity> findAll() {
        return categoriapositorio.findAll();
    }

    @Override
    public CategoriaEntity findById(Long id) {
        return categoriapositorio.findById(id).get();
    }

    @Override
    public CategoriaEntity add(CategoriaEntity c) {
        return categoriapositorio.save(c);
    }

    @Override
    public CategoriaEntity update(CategoriaEntity c) {
        CategoriaEntity objcarrera = categoriapositorio.getById(c.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(c, objcarrera);
        return categoriapositorio.save(objcarrera);
    }

    @Override
    public CategoriaEntity delete(CategoriaEntity c) {
        CategoriaEntity objcarrera = categoriapositorio.getById(c.getCodigo());
        objcarrera.setEstado(false);
        return categoriapositorio.save(objcarrera);
    }

    @Override
    public List<CategoriaEntity> findAllCustom() {
        return categoriapositorio.findAllCustom();
    }
    
    @Override
    public List<CategoriaEntity> findAllCustomEnable() {
        return categoriapositorio.findAllCustomEnable();
    }
    
    @Override
    public CategoriaEntity enable(CategoriaEntity p) {
        CategoriaEntity objcarrera = categoriapositorio.getById(p.getCodigo());
        objcarrera.setEstado(true);
        return categoriapositorio.save(objcarrera);
    }
}
