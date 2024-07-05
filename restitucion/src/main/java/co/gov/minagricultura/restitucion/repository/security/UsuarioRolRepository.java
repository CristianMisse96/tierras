package co.gov.minagricultura.restitucion.repository.security;

import co.gov.minagricultura.restitucion.entity.security.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {
}