
package com.villaandina.VillaAndina.service;

import com.villaandina.VillaAndina.entity.EmpleadoEntity;
import com.villaandina.VillaAndina.repository.EmpleadoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    @Autowired
    private EmpleadoRepository empleadorepositorio;
    
    @Override
    public List<EmpleadoEntity> findAll() {
        return empleadorepositorio.findAll();
    }

    @Override
    public Optional<EmpleadoEntity> findById(Long id) {
        return empleadorepositorio.findById(id);
    }

    @Override
    public EmpleadoEntity add(EmpleadoEntity e) {
        return empleadorepositorio.save(e);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity e) {
        EmpleadoEntity objempleado = empleadorepositorio.getById(e.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(e, objempleado);
        return empleadorepositorio.save(objempleado);
    }

    @Override
    public EmpleadoEntity delete(EmpleadoEntity e) {
        EmpleadoEntity objempleado = empleadorepositorio.getById(e.getCodigo());
        objempleado.setEstado(false);
        return empleadorepositorio.save(objempleado);
    }

    @Override
    public List<EmpleadoEntity> findAllCustom() {
        return empleadorepositorio.findAllCustom();
    }
}
