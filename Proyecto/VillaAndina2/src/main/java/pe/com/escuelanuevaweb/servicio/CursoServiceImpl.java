package pe.com.escuelanuevaweb.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.escuelanuevaweb.modelo.CursoEntity;
import pe.com.escuelanuevaweb.repositorio.CursoRepository;

//@Service define a la clase como un servicio
@Service
public class CursoServiceImpl implements CursoService {

    //@Autowired  permite inyectar la dependencia
    @Autowired
    private CursoRepository cursorepositorio;

    @Override
    public List<CursoEntity> findAll() {
        return cursorepositorio.findAll();
    }

    @Override
    public CursoEntity findById(Long id) {
        return cursorepositorio.findById(id).get();
    }

    @Override
    public CursoEntity add(CursoEntity c) {
        return cursorepositorio.save(c);
    }

    @Override
    public CursoEntity update(CursoEntity c) {
        CursoEntity objcurso = cursorepositorio.getById(c.getCodigo());
        //BeansUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(c, objcurso);
        return cursorepositorio.save(objcurso);
    }

    @Override
    public CursoEntity delete(CursoEntity c) {
        CursoEntity objcurso = cursorepositorio.getById(c.getCodigo());
        objcurso.setEstado(false);
        return cursorepositorio.save(objcurso);
    }

    @Override
    public List<CursoEntity> findAllCustom() {
        return cursorepositorio.findAllCustom();
    }

    @Override
    public CursoEntity enable(CursoEntity c) {
        CursoEntity objcurso = cursorepositorio.getById(c.getCodigo());
        objcurso.setEstado(true);
        return cursorepositorio.save(objcurso);
    }

}
