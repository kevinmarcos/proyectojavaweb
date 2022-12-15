
package pe.com.escuelanuevaweb.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.escuelanuevaweb.modelo.DistritoEntity;
import pe.com.escuelanuevaweb.repositorio.DistritoRepository;

@Service
public class DistritoServiceImpl implements DistritoService{
    @Autowired
    private DistritoRepository distritorepositorio;

    @Override
    public List<DistritoEntity> findAll() {
        return distritorepositorio.findAll();
    }

    @Override
    public DistritoEntity findById(Long id) {
        return distritorepositorio.findById(id).get();
    }

    @Override
    public DistritoEntity add(DistritoEntity d) {
        return distritorepositorio.save(d);
    }

    @Override
    public DistritoEntity update(DistritoEntity d) {
        DistritoEntity objcarrera = distritorepositorio.getById(d.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(d, objcarrera);
        return distritorepositorio.save(objcarrera);
    }

    @Override
    public DistritoEntity delete(DistritoEntity d) {
        DistritoEntity objcarrera = distritorepositorio.getById(d.getCodigo());
        objcarrera.setEstado(false);
        return distritorepositorio.save(objcarrera);
    }

    @Override
    public List<DistritoEntity> findAllCustom() {
        return distritorepositorio.findAllCustom();
    }
    
    @Override
    public List<DistritoEntity> findAllCustomEnable() {
        return distritorepositorio.findAllCustomEnable();
    }
    
    @Override
    public DistritoEntity enable(DistritoEntity p) {
        DistritoEntity objcarrera = distritorepositorio.getById(p.getCodigo());
        objcarrera.setEstado(true);
        return distritorepositorio.save(objcarrera);
    }
}
