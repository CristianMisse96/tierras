package co.gov.minagricultura.restitucion.mapper;

import co.gov.minagricultura.restitucion.entity.*;
import co.gov.minagricultura.restitucion.model.DepartamentoDTO;
import co.gov.minagricultura.restitucion.model.MunicipioDTO;
import co.gov.minagricultura.restitucion.model.ParametricaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ParametricasMapper {

    ParametricasMapper INSTANCE = Mappers.getMapper(ParametricasMapper.class);

    DepartamentoDTO toDepartamentoDTO(DepartamentoEntity departamentoEntity);

    MunicipioDTO toMunicipioDTO(MunicipioEntity municipioEntity);

    ParametricaDTO tipoPlanToDTO(TipoPlan tipoPlan);
    ParametricaDTO lineaPrincipalToDTO(LineaPrincipal lineaPrincipal);
    ParametricaDTO lineaPlanTipoToDTO(LineaPlanTipo lineaPlanTipo);
    ParametricaDTO unidadToDTO(Unidad unidad);
    ParametricaDTO tipoInsumoToDTO(TipoInsumo tipoInsumo);
}
