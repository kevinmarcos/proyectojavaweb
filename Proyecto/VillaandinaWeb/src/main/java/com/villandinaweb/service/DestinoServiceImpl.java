
package com.villandinaweb.service;

import com.villandinaweb.entity.DestinoEntity;
import com.villandinaweb.repository.DestinoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinoServiceImpl implements DestinoService{

    @Autowired
    private DestinoRepository destinorepositorio;

    @Override
    public List<DestinoEntity> findAll() {
        return destinorepositorio.findAll();
    }

    @Override
    public Optional<DestinoEntity> findById(Long id) {
        return destinorepositorio.findById(id);
    }

    @Override
    public DestinoEntity add(DestinoEntity d) {
        return destinorepositorio.save(d);
    }

    @Override
    public DestinoEntity update(DestinoEntity d) {
        DestinoEntity objcarrera = destinorepositorio.getById(d.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(d, objcarrera);
        return destinorepositorio.save(objcarrera);
    }

    @Override
    public DestinoEntity delete(DestinoEntity d) {
        DestinoEntity objcarrera = destinorepositorio.getById(d.getCodigo());
        objcarrera.setEstado(false);
        return destinorepositorio.save(objcarrera);
    }

    @Override
    public List<DestinoEntity> findAllCustom() {
        return destinorepositorio.findAllCustom();
    }    
}
