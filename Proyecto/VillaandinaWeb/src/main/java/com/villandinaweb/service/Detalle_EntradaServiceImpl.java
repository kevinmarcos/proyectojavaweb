
package com.villandinaweb.service;

import com.villandinaweb.entity.Detalle_EntradaEntity;
import com.villandinaweb.repository.Detalle_EntradaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Detalle_EntradaServiceImpl implements Detalle_EntradaService{
    @Autowired
    private Detalle_EntradaRepository detalle_entradarepositorio;

    @Override
    public List<Detalle_EntradaEntity> findAll() {
        return detalle_entradarepositorio.findAll();
    }

    @Override
    public Detalle_EntradaEntity findById(Long id) {
        return detalle_entradarepositorio.findById(id).get();
    }

    @Override
    public Detalle_EntradaEntity add(Detalle_EntradaEntity d) {
        return detalle_entradarepositorio.save(d);
    }

    @Override
    public Detalle_EntradaEntity update(Detalle_EntradaEntity d) {
        Detalle_EntradaEntity objcarrera = detalle_entradarepositorio.getById(d.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(d, objcarrera);
        return detalle_entradarepositorio.save(objcarrera);
    }

    @Override
    public Detalle_EntradaEntity delete(Detalle_EntradaEntity d) {
        Detalle_EntradaEntity objcarrera = detalle_entradarepositorio.getById(d.getCodigo());
        objcarrera.setEstado(false);
        return detalle_entradarepositorio.save(objcarrera);
    }

    @Override
    public List<Detalle_EntradaEntity> findAllCustom() {
        return detalle_entradarepositorio.findAllCustom();
    }
    
    @Override
    public List<Detalle_EntradaEntity> findAllCustomEnable() {
        return detalle_entradarepositorio.findAllCustomEnable();
    }
    
    @Override
    public Detalle_EntradaEntity enable(Detalle_EntradaEntity p) {
        Detalle_EntradaEntity objcarrera = detalle_entradarepositorio.getById(p.getCodigo());
        objcarrera.setEstado(true);
        return detalle_entradarepositorio.save(objcarrera);
    }
}
