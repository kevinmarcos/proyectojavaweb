package pe.com.escuelanuevaweb.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.escuelanuevaweb.modelo.RolEntity;
import pe.com.escuelanuevaweb.repositorio.RolRepository;

public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolrepositorio;

    @Override
    public List<RolEntity> findAll() {
        return rolrepositorio.findAll();
    }

    @Override
    public Optional<RolEntity> findById(Long id) {
        return rolrepositorio.findById(id);
    }

    @Override
    public RolEntity add(RolEntity r) {
        return rolrepositorio.save(r);
    }

    @Override
    public RolEntity update(RolEntity r) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RolEntity delete(RolEntity r) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RolEntity> findAllCustom() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
