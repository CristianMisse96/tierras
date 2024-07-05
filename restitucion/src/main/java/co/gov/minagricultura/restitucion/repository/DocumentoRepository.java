package co.gov.minagricultura.restitucion.repository;

import co.gov.minagricultura.restitucion.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    Optional<Documento> findByIdAndProveedorId(Long id, Long proveedorId);
}
