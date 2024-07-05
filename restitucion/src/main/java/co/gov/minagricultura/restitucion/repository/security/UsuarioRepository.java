package co.gov.minagricultura.restitucion.repository.security;

import co.gov.minagricultura.restitucion.entity.security.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
