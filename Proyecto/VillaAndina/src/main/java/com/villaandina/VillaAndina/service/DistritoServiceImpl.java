
package com.villaandina.VillaAndina.service;

import com.villaandina.VillaAndina.entity.DistritoEntity;
import com.villaandina.VillaAndina.repository.DistritoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistritoServiceImpl implements DistritoService{
    
    //@Autowired permite inyectar la dependencia
    @Autowired
    
    private DistritoRepository distritorepositorio;
            
    @Override
    public List<DistritoEntity> findAll() {
        return distritorepositorio.findAll();
    }
    
    @Override
    public Optional<DistritoEntity> findById(Long id) {
        return distritorepositorio.findById(id);
    }
    
    @Override
    public DistritoEntity add(DistritoEntity d) {
        return distritorepositorio.save(d);
    }

    @Override
    public DistritoEntity update(DistritoEntity d) {
        DistritoEntity objcurso = distritorepositorio.getById(d.getCodigo());
        //BeanUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(d, objcurso);
        return distritorepositorio.save(objcurso);
    }

    @Override
    public List<DistritoEntity> findAllCustom() {
        return distritorepositorio.findAllCustom();
    }

    @Override
    public DistritoEntity delete(DistritoEntity d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
