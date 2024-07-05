package co.gov.minagricultura.restitucion.repository;

import co.gov.minagricultura.restitucion.entity.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long>, JpaSpecificationExecutor<DepartamentoEntity> {
}
