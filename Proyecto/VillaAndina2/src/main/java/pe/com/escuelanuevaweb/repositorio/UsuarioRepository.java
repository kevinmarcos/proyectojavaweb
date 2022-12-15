
package pe.com.escuelanuevaweb.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.escuelanuevaweb.modelo.UsuarioEntity;

@Repository
public interface UsuarioRepository extends
        JpaRepository<UsuarioEntity, Long> {
    
    public UsuarioEntity findByEmail(String email);
    
}
