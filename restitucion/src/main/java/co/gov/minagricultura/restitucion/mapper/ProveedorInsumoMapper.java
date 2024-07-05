package co.gov.minagricultura.restitucion.mapper;

import co.gov.minagricultura.restitucion.entity.ProveedorInsumo;
import co.gov.minagricultura.restitucion.model.ProveedorInsumoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProveedorInsumoMapper {
    ProveedorInsumoMapper INSTANCE = Mappers.getMapper(ProveedorInsumoMapper.class);

    ProveedorInsumoDTO toDTO(ProveedorInsumo proveedorInsumo);
    ProveedorInsumo toEntity(ProveedorInsumoDTO proveedorInsumoDTO);
}
