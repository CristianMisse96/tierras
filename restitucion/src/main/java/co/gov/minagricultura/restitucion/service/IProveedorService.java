package co.gov.minagricultura.restitucion.service;

import co.gov.minagricultura.restitucion.model.ProveedorDTO;
import co.gov.minagricultura.restitucion.model.ProveedorResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProveedorService {
    ProveedorResponseDTO crearProveedor(ProveedorDTO proveedorDTO);

    ProveedorResponseDTO obtenerProveedor(Long id);

    Page<ProveedorResponseDTO> filtrarProveedores(String nit,
                                          String razonSocial,
                                          String municipio,
                                          String lugarEntregaProducto,
                                          String nombreRepresentanteLegal,
                                          String nombreActividadEconomica,
                                          String codigoCIIU,
                                          String nombreInsumo,
                                          Pageable pageable);
}
