
package com.villandinaweb.service;

import com.villandinaweb.entity.ProveedoresEntity;
import com.villandinaweb.repository.ProveedoresRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProveedoresServiceImpl implements ProveedoresService{
    @Autowired
    private ProveedoresRepository proveedoresrepositorio;

    @Override
    public List<ProveedoresEntity> findAll() {
        return proveedoresrepositorio.findAll();
    }

    @Override
    public Optional<ProveedoresEntity> findById(Long id) {
        return proveedoresrepositorio.findById(id);
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
}
