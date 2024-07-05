package co.gov.minagricultura.restitucion.service;

import co.gov.minagricultura.restitucion.model.DepartamentoDTO;
import co.gov.minagricultura.restitucion.model.MunicipioDTO;
import co.gov.minagricultura.restitucion.model.ParametricaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IParametricasService {

    Page<DepartamentoDTO> getDepartamentos(String nombre, Pageable pageable);

    Page<MunicipioDTO> getMunicipios(String nombre, String nombreDepartamento, Pageable pageable);

    List<ParametricaDTO> getTipoPlan();

    List<ParametricaDTO> getLineaPrincipal();

    List<ParametricaDTO> getLineaPlanTipo();

    List<ParametricaDTO> getTipoInsumo();

    List<ParametricaDTO> getUnidad();
}
