
package com.villaandina.VillaAndina.service;

import com.villaandina.VillaAndina.entity.ProductosEntity;
import com.villaandina.VillaAndina.repository.ProductosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosServiceImpl implements ProductosService{
    @Autowired
    private ProductosRepository productorepositorio;
    
    @Override
    public List<ProductosEntity> findAll() {
        return productorepositorio.findAll();
    }

    @Override
    public Optional<ProductosEntity> findById(Long id) {
        return productorepositorio.findById(id);
    }

    @Override
    public ProductosEntity add(ProductosEntity p) {
        return productorepositorio.save(p);
    }

    @Override
    public ProductosEntity update(ProductosEntity p) {
        ProductosEntity objproducto = productorepositorio.getById(p.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(p, objproducto);
        return productorepositorio.save(objproducto);
    }

    @Override
    public ProductosEntity delete(ProductosEntity p) {
        ProductosEntity objcarrera = productorepositorio.getById(p.getCodigo());
        objcarrera.setEstado(false);
        return productorepositorio.save(objcarrera);
    }

    @Override
    public List<ProductosEntity> findAllCustom() {
        return productorepositorio.findAllCustom();
    }
}
