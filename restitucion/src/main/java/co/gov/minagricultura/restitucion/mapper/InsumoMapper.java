package co.gov.minagricultura.restitucion.mapper;

import co.gov.minagricultura.restitucion.entity.Insumo;
import co.gov.minagricultura.restitucion.model.InsumoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InsumoMapper {
    InsumoMapper INSTANCE = Mappers.getMapper(InsumoMapper.class);

    InsumoDTO toDTO(Insumo insumo);
    Insumo toEntity(InsumoDTO insumoDTO);
}

