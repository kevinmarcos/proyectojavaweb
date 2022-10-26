
package com.villaandina.VillaAndina.service;

import com.villaandina.VillaAndina.entity.CategoriaEntity;
import com.villaandina.VillaAndina.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaRepository categoriarepositorio;
    
    @Override
    public List<CategoriaEntity> findAll() {
        return categoriarepositorio.findAll();
    }

    @Override
    public Optional<CategoriaEntity> findById(Long id) {
        return categoriarepositorio.findById(id);
    }

    @Override
    public CategoriaEntity add(CategoriaEntity c) {
        return categoriarepositorio.save(c);
    }

    @Override
    public CategoriaEntity update(CategoriaEntity c) {
        CategoriaEntity objcarrera = categoriarepositorio.getById(c.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(c, objcarrera);
        return categoriarepositorio.save(objcarrera);
    }

    

    @Override
    public List<CategoriaEntity> findAllCustom() {
        return categoriarepositorio.findAllCustom();
    }

    @Override
    public CategoriaEntity delete(CategoriaEntity c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
