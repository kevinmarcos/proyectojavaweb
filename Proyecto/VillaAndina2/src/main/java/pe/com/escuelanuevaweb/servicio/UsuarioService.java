package pe.com.escuelanuevaweb.servicio;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import pe.com.escuelanuevaweb.dto.UsuarioRegitroDTO;
import pe.com.escuelanuevaweb.modelo.UsuarioEntity;

public interface UsuarioService extends UserDetailsService {

    UsuarioEntity add(UsuarioRegitroDTO udto);

    List<UsuarioEntity> findAll();
}
