
package com.villaandina.VillaAndina.service;

import com.villaandina.VillaAndina.entity.ProveedoresEntity;
import com.villaandina.VillaAndina.repository.ProveedoresRepository;
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
        ProveedoresEntity objproveedores = proveedoresrepositorio.getById(p.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(p, objproveedores);
        return proveedoresrepositorio.save(objproveedores);
    }

    @Override
    public ProveedoresEntity delete(ProveedoresEntity p) {
        ProveedoresEntity objproveedores = proveedoresrepositorio.getById(p.getCodigo());
        objproveedores.setEstado(false);
        return proveedoresrepositorio.save(objproveedores);
    }

    @Override
    public List<ProveedoresEntity> findAllCustom() {
        return proveedoresrepositorio.findAllCustom();
    }
}
