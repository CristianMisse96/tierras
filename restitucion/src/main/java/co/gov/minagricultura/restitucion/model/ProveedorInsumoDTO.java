package co.gov.minagricultura.restitucion.model;

import co.gov.minagricultura.restitucion.entity.Insumo;
import co.gov.minagricultura.restitucion.entity.ProveedorEntity;

public class ProveedorInsumoDTO {
    private Long id;

    private ProveedorEntity proveedor;

    private Insumo insumo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
}

