
package com.villaandina.VillaAndina.service;

import com.villaandina.VillaAndina.entity.Entrada_ProductoEntity;
import com.villaandina.VillaAndina.repository.Entrada_ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Entrada_ProductoServiceImpl implements Entrada_ProductoService{
    //@Autowired permite inyectar la dependencia
    @Autowired
    
    private Entrada_ProductoRepository entrada_repositoriorepositorio;
            
    @Override
    public List<Entrada_ProductoEntity> findAll() {
        return entrada_repositoriorepositorio.findAll();
    }
    
    @Override
    public Optional<Entrada_ProductoEntity> findById(Long id) {
        return entrada_repositoriorepositorio.findById(id);
    }
    
    @Override
    public Entrada_ProductoEntity add(Entrada_ProductoEntity e) {
        return entrada_repositoriorepositorio.save(e);
    }

    @Override
    public Entrada_ProductoEntity update(Entrada_ProductoEntity e) {
        Entrada_ProductoEntity objcurso = entrada_repositoriorepositorio.getById(e.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(e, objcurso);
        return entrada_repositoriorepositorio.save(objcurso);
    }

    @Override
    public List<Entrada_ProductoEntity> findAllCustom() {
        return entrada_repositoriorepositorio.findAllCustom();
    }

    @Override
    public Entrada_ProductoEntity delete(Entrada_ProductoEntity e) {
        Entrada_ProductoEntity objentrada_producto = entrada_repositoriorepositorio.getById(e.getCodigo());
        objentrada_producto.setEstado(false);
        return entrada_repositoriorepositorio.save(objentrada_producto);
    }
}
