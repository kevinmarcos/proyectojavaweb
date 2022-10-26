
package com.villandinaweb.service;

import com.villandinaweb.entity.Entrada_ProductoEntity;
import com.villandinaweb.repository.Entrada_ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Entrada_ProductoServiceImpl implements Entrada_ProductoService{
    @Autowired
    private Entrada_ProductoRepository entrada_productorepositorio;

    @Override
    public List<Entrada_ProductoEntity> findAll() {
        return entrada_productorepositorio.findAll();
    }

    @Override
    public Optional<Entrada_ProductoEntity> findById(Long id) {
        return entrada_productorepositorio.findById(id);
    }

    @Override
    public Entrada_ProductoEntity add(Entrada_ProductoEntity e) {
        return entrada_productorepositorio.save(e);
    }

    @Override
    public Entrada_ProductoEntity update(Entrada_ProductoEntity e) {
        Entrada_ProductoEntity objcarrera = entrada_productorepositorio.getById(e.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(e, objcarrera);
        return entrada_productorepositorio.save(objcarrera);
    }

    @Override
    public Entrada_ProductoEntity delete(Entrada_ProductoEntity e) {
        Entrada_ProductoEntity objcarrera = entrada_productorepositorio.getById(e.getCodigo());
        objcarrera.setEstado(false);
        return entrada_productorepositorio.save(objcarrera);
    }

    @Override
    public List<Entrada_ProductoEntity> findAllCustom() {
        return entrada_productorepositorio.findAllCustom();
    }
}
