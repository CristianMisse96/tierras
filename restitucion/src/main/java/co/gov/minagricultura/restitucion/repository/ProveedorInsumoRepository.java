package co.gov.minagricultura.restitucion.repository;

import co.gov.minagricultura.restitucion.entity.ProveedorEntity;
import co.gov.minagricultura.restitucion.entity.ProveedorInsumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProveedorInsumoRepository extends JpaRepository<ProveedorInsumo, Long> {

    List<ProveedorInsumo> findByProveedor(ProveedorEntity proveedor);
    void deleteByProveedor(ProveedorEntity proveedor);
}
