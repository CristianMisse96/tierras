package co.gov.minagricultura.restitucion.service.impl;

import co.gov.minagricultura.restitucion.entity.Insumo;
import co.gov.minagricultura.restitucion.mapper.InsumoMapper;
import co.gov.minagricultura.restitucion.model.InsumoDTO;
import co.gov.minagricultura.restitucion.repository.InsumoRepository;
import co.gov.minagricultura.restitucion.service.IInsumoService;
import co.gov.minagricultura.restitucion.specification.InsumoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsumoService implements IInsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    @Override
    public List<InsumoDTO> getAll() {
        return insumoRepository.findAll().stream()
                .map(InsumoMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InsumoDTO getById(Long id) {
        return insumoRepository.findById(id)
                .map(InsumoMapper.INSTANCE::toDTO)
                .orElse(null);
    }

    @Override
    public InsumoDTO save(InsumoDTO insumoDTO) {
        Insumo insumo = InsumoMapper.INSTANCE.toEntity(insumoDTO);
        insumo = insumoRepository.save(insumo);
        return InsumoMapper.INSTANCE.toDTO(insumo);
    }

    @Override
    public void delete(Long id) {
        insumoRepository.deleteById(id);
    }

    @Override
    public Page<InsumoDTO> filtrarInsumos(String departamentoNombre,
                                          String tipoPlanNombre,
                                          String lineaPrincipalNombre,
                                          String lineaPlanTipoNombre,
                                          String unidadNombre,
                                          String insumo,
                                          String descripcion,
                                          Double costo,
                                          Double precioBase,
                                          Double precioTecho,
                                          Pageable pageable) {

        InsumoSpecification spec = new InsumoSpecification(departamentoNombre, tipoPlanNombre, lineaPrincipalNombre, lineaPlanTipoNombre, unidadNombre, insumo, descripcion, costo, precioBase, precioTecho);

        return insumoRepository.findAll(spec, pageable)
                .map(InsumoMapper.INSTANCE::toDTO);
    }

}
