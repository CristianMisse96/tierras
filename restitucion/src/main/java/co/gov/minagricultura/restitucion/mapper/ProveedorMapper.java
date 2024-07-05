package co.gov.minagricultura.restitucion.mapper;

import co.gov.minagricultura.restitucion.entity.ProveedorEntity;
import co.gov.minagricultura.restitucion.entity.ProveedorInsumo;
import co.gov.minagricultura.restitucion.model.InsumoDTO;
import co.gov.minagricultura.restitucion.model.ProveedorDTO;
import co.gov.minagricultura.restitucion.model.ProveedorResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface ProveedorMapper {

    ProveedorMapper INSTANCE = Mappers.getMapper(ProveedorMapper.class);

    ProveedorDTO entityToDto(ProveedorEntity proveedorEntity);

    ProveedorEntity dtoToEntity(ProveedorDTO proveedorDTO);

    @Mapping(target = "insumos", expression = "java(mapInsumos(proveedor.getInsumos()))")
    ProveedorResponseDTO toResponseDTO(ProveedorEntity proveedor);

    default List<InsumoDTO> mapInsumos(List<ProveedorInsumo> proveedorInsumos) {
        return Optional.ofNullable(proveedorInsumos)
                .map(list -> list.stream()
                        .map(proveedorInsumo -> InsumoMapper.INSTANCE.toDTO(proveedorInsumo.getInsumo()))
                        .collect(Collectors.toList()))
                .orElseGet(Collections::emptyList);
    }
}
