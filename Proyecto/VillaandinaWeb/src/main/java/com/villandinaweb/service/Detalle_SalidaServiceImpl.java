
package com.villandinaweb.service;


import com.villandinaweb.entity.Detalle_SalidaEntity;
import com.villandinaweb.repository.Detalle_SalidaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Detalle_SalidaServiceImpl implements Detalle_SalidaService{
    @Autowired
    private Detalle_SalidaRepository detalle_salidarepositorio;

    @Override
    public List<Detalle_SalidaEntity> findAll() {
        return detalle_salidarepositorio.findAll();
    }

    @Override
    public Detalle_SalidaEntity findById(Long id) {
        return detalle_salidarepositorio.findById(id).get();
    }

    @Override
    public Detalle_SalidaEntity add(Detalle_SalidaEntity d) {
        return detalle_salidarepositorio.save(d);
    }

    @Override
    public Detalle_SalidaEntity update(Detalle_SalidaEntity d) {
        Detalle_SalidaEntity objcarrera = detalle_salidarepositorio.getById(d.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(d, objcarrera);
        return detalle_salidarepositorio.save(objcarrera);
    }

    @Override
    public Detalle_SalidaEntity delete(Detalle_SalidaEntity d) {
        Detalle_SalidaEntity objcarrera = detalle_salidarepositorio.getById(d.getCodigo());
        objcarrera.setEstado(false);
        return detalle_salidarepositorio.save(objcarrera);
    }

    @Override
    public List<Detalle_SalidaEntity> findAllCustom() {
        return detalle_salidarepositorio.findAllCustom();
    }
    
    @Override
    public List<Detalle_SalidaEntity> findAllCustomEnable() {
        return detalle_salidarepositorio.findAllCustomEnable();
    }
    
    @Override
    public Detalle_SalidaEntity enable(Detalle_SalidaEntity p) {
        Detalle_SalidaEntity objcarrera = detalle_salidarepositorio.getById(p.getCodigo());
        objcarrera.setEstado(true);
        return detalle_salidarepositorio.save(objcarrera);
    }
}
