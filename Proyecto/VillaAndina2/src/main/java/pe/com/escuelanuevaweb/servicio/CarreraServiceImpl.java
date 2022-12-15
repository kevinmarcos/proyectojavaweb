package pe.com.escuelanuevaweb.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.escuelanuevaweb.modelo.CarreraEntity;
import pe.com.escuelanuevaweb.modelo.CursoEntity;
import pe.com.escuelanuevaweb.repositorio.CarreraRepository;
import pe.com.escuelanuevaweb.repositorio.CursoRepository;

@Service
public class CarreraServiceImpl implements CarreraService {

    @Autowired
    private CarreraRepository carrerarepositorio;
    @Autowired
    private CursoRepository cursorepositorio;

    @Override
    public List<CarreraEntity> findAll() {
        return carrerarepositorio.findAll();
    }

    @Override
    public CarreraEntity findById(Long id) {
        return carrerarepositorio.findById(id).get();
    }

    @Override
    public CarreraEntity add(CarreraEntity c) {
        return carrerarepositorio.save(c);
    }

    @Override
    public CarreraEntity update(CarreraEntity c) {
        CarreraEntity objcarrera = carrerarepositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objcarrera);
        return carrerarepositorio.save(objcarrera);
    }

    @Override
    public CarreraEntity delete(CarreraEntity c) {
        CarreraEntity objcarrera = carrerarepositorio.getById(c.getCodigo());
        objcarrera.setEstado(false);
        return carrerarepositorio.save(objcarrera);
    }

    @Override
    public List<CarreraEntity> findAllCustom() {
        return carrerarepositorio.findAllCustom();
    }

    @Override
    public CarreraEntity enable(CarreraEntity c) {
        CarreraEntity objcurso = carrerarepositorio.getById(c.getCodigo());
        objcurso.setEstado(true);
        return carrerarepositorio.save(objcurso);
    }

}
