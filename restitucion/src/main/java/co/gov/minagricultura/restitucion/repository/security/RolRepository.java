package co.gov.minagricultura.restitucion.repository.security;

import co.gov.minagricultura.restitucion.entity.security.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}

