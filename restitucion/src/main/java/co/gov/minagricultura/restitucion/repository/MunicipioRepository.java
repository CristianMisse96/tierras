package co.gov.minagricultura.restitucion.repository;

import co.gov.minagricultura.restitucion.entity.MunicipioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MunicipioRepository extends JpaRepository<MunicipioEntity, Long>, JpaSpecificationExecutor<MunicipioEntity> {
}
