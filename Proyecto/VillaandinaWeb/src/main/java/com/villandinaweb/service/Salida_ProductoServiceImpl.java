
package com.villandinaweb.service;

import com.villandinaweb.entity.Salida_ProductoEntity;
import com.villandinaweb.repository.Salida_ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Salida_ProductoServiceImpl implements Salida_ProductoService{
    @Autowired
    private Salida_ProductoRepository salida_productorepositorio;

    @Override
    public List<Salida_ProductoEntity> findAll() {
        return salida_productorepositorio.findAll();
    }

    @Override
    public Optional<Salida_ProductoEntity> findById(Long id) {
        return salida_productorepositorio.findById(id);
    }

    @Override
    public Salida_ProductoEntity add(Salida_ProductoEntity s) {
        return salida_productorepositorio.save(s);
    }

    @Override
    public Salida_ProductoEntity update(Salida_ProductoEntity s) {
        Salida_ProductoEntity objcarrera = salida_productorepositorio.getById(s.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(s, objcarrera);
        return salida_productorepositorio.save(objcarrera);
    }

    @Override
    public Salida_ProductoEntity delete(Salida_ProductoEntity s) {
        Salida_ProductoEntity objcarrera = salida_productorepositorio.getById(s.getCodigo());
        objcarrera.setEstado(false);
        return salida_productorepositorio.save(objcarrera);
    }

    @Override
    public List<Salida_ProductoEntity> findAllCustom() {
        return salida_productorepositorio.findAllCustom();
    }
}
