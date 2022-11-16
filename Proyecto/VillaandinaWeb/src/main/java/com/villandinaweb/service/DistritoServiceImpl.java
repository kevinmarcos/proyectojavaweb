
package com.villandinaweb.service;

import com.villandinaweb.entity.Detalle_SalidaEntity;
import com.villandinaweb.entity.DistritoEntity;
import com.villandinaweb.repository.Detalle_SalidaRepository;
import com.villandinaweb.repository.DistritoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistritoServiceImpl implements DistritoService{
    @Autowired
    private DistritoRepository distritorepositorio;

    @Override
    public List<DistritoEntity> findAll() {
        return distritorepositorio.findAll();
    }

    @Override
    public Optional<DistritoEntity> findById(Long id) {
        return distritorepositorio.findById(id);
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
}