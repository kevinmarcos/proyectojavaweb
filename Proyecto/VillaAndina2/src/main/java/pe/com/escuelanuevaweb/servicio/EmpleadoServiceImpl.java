
package pe.com.escuelanuevaweb.servicio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.escuelanuevaweb.modelo.EmpleadoEntity;
import pe.com.escuelanuevaweb.repositorio.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    @Autowired
    private EmpleadoRepository empleadorepositorio;

    @Override
    public List<EmpleadoEntity> findAll() {
        return empleadorepositorio.findAll();
    }

    @Override
    public EmpleadoEntity findById(Long id) {
        return empleadorepositorio.findById(id).get();
    }

    @Override
    public EmpleadoEntity add(EmpleadoEntity e) {
        return empleadorepositorio.save(e);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity e) {
        EmpleadoEntity objcarrera = empleadorepositorio.getById(e.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(e, objcarrera);
        return empleadorepositorio.save(objcarrera);
    }

    @Override
    public EmpleadoEntity delete(EmpleadoEntity e) {
        EmpleadoEntity objcarrera = empleadorepositorio.getById(e.getCodigo());
        objcarrera.setEstado(false);
        return empleadorepositorio.save(objcarrera);
    }

    @Override
    public List<EmpleadoEntity> findAllCustom() {
        return empleadorepositorio.findAllCustom();
    }
    
    @Override
    public List<EmpleadoEntity> findAllCustomEnable() {
        return empleadorepositorio.findAllCustomEnable();
    }
    
    @Override
    public EmpleadoEntity enable(EmpleadoEntity p) {
        EmpleadoEntity objcarrera = empleadorepositorio.getById(p.getCodigo());
        objcarrera.setEstado(true);
        return empleadorepositorio.save(objcarrera);
    }
}
