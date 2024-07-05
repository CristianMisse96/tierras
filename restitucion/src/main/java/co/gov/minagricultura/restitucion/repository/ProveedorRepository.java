package co.gov.minagricultura.restitucion.repository;

import co.gov.minagricultura.restitucion.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long>, JpaSpecificationExecutor<ProveedorEntity> {
}
