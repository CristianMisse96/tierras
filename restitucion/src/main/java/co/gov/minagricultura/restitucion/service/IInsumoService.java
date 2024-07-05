package co.gov.minagricultura.restitucion.service;

import co.gov.minagricultura.restitucion.model.InsumoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IInsumoService {

    List<InsumoDTO> getAll();

    InsumoDTO getById(Long id);

    InsumoDTO save(InsumoDTO insumoDTO);

    void delete(Long id);

    Page<InsumoDTO> filtrarInsumos(String departamentoNombre,
                                   String tipoPlanNombre,
                                   String lineaPrincipalNombre,
                                   String lineaPlanTipoNombre,
                                   String unidadNombre,
                                   String insumo,
                                   String descripcion,
                                   Double costo,
                                   Double precioBase,
                                   Double precioTecho,
                                   Pageable pageable);
}
