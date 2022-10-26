package com.villandinaweb.service;

import com.villandinaweb.entity.CategoriaEntity;
import com.villandinaweb.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriapositorio;

    @Override
    public List<CategoriaEntity> findAll() {
        return categoriapositorio.findAll();
    }

    @Override
    public Optional<CategoriaEntity> findById(Long id) {
        return categoriapositorio.findById(id);
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
}
