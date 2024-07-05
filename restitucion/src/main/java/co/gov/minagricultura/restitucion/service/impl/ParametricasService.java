package co.gov.minagricultura.restitucion.service.impl;


import co.gov.minagricultura.restitucion.entity.DepartamentoEntity;
import co.gov.minagricultura.restitucion.entity.MunicipioEntity;
import co.gov.minagricultura.restitucion.mapper.ParametricasMapper;
import co.gov.minagricultura.restitucion.model.DepartamentoDTO;
import co.gov.minagricultura.restitucion.model.MunicipioDTO;
import co.gov.minagricultura.restitucion.model.ParametricaDTO;
import co.gov.minagricultura.restitucion.repository.*;
import co.gov.minagricultura.restitucion.service.IParametricasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ParametricasService implements IParametricasService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private LineaPlanTipoRepository lineaPlanTipoRepository;

    @Autowired
    private LineaPrincipalRepository lineaPrincipalRepository;

    @Autowired
    private TipoInsumoRepository tipoInsumoRepository;

    @Autowired
    private TipoPlanRepository tipoPlanRepository;

    @Autowired
    private UnidadRepository unidadRepository;

    @Override
    public Page<DepartamentoDTO> getDepartamentos(String nombre, Pageable pageable) {

        Specification<DepartamentoEntity> spec = (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("nombre")));
            if (nombre != null) {
                return criteriaBuilder.and(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"),
                        criteriaBuilder.equal(root.get("estado"), "ACTIVO")
                );
            }
            return criteriaBuilder.equal(root.get("estado"), "ACTIVO");
        };
        return departamentoRepository.findAll(spec, pageable)
                .map(ParametricasMapper.INSTANCE::toDepartamentoDTO);
    }


    @Override
    public Page<MunicipioDTO> getMunicipios(String nombre, String nombreDepartamento, Pageable pageable) {
        Specification<MunicipioEntity> spec = (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("nombre")));
            if (nombre != null && nombreDepartamento != null) {
                return criteriaBuilder.and(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("departamento").get("nombre")), "%" + nombreDepartamento.toLowerCase() + "%"),
                        criteriaBuilder.equal(root.get("estado"), "ACTIVO")
                );
            } else if (nombre != null) {
                return criteriaBuilder.and(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"),
                        criteriaBuilder.equal(root.get("estado"), "ACTIVO")
                );
            } else if (nombreDepartamento != null) {
                return criteriaBuilder.and(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("departamento").get("nombre")), "%" + nombreDepartamento.toLowerCase() + "%"),
                        criteriaBuilder.equal(root.get("estado"), "ACTIVO")
                );
            }
            return criteriaBuilder.equal(root.get("estado"), "ACTIVO");
        };
        return municipioRepository.findAll(spec, pageable)
                .map(ParametricasMapper.INSTANCE::toMunicipioDTO);
    }

    @Override
    public List<ParametricaDTO> getTipoPlan() {
        return tipoPlanRepository.findAll().stream()
                .map(ParametricasMapper.INSTANCE::tipoPlanToDTO)
                .toList();
    }

    @Override
    public List<ParametricaDTO> getLineaPrincipal() {
        return lineaPrincipalRepository.findAll().stream()
                .map(ParametricasMapper.INSTANCE::lineaPrincipalToDTO)
                .toList();
    }

    @Override
    public List<ParametricaDTO> getLineaPlanTipo() {
        return lineaPlanTipoRepository.findAll().stream()
                .map(ParametricasMapper.INSTANCE::lineaPlanTipoToDTO)
                .toList();
    }

    @Override
    public List<ParametricaDTO> getTipoInsumo() {
        return tipoInsumoRepository.findAll().stream()
                .map(ParametricasMapper.INSTANCE::tipoInsumoToDTO)
                .toList();
    }

    @Override
    public List<ParametricaDTO> getUnidad() {
        return unidadRepository.findAll().stream()
                .map(ParametricasMapper.INSTANCE::unidadToDTO)
                .toList();
    }


}
