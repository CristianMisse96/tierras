package co.gov.minagricultura.restitucion.controller;

import co.gov.minagricultura.restitucion.model.DepartamentoDTO;
import co.gov.minagricultura.restitucion.model.MunicipioDTO;
import co.gov.minagricultura.restitucion.model.ParametricaDTO;
import co.gov.minagricultura.restitucion.service.IParametricasService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/parametricas")
public class ParametricasController {

    @Autowired
    private IParametricasService iParametricasService;


    @GetMapping("/departamentos")
    public Page<DepartamentoDTO> getDepartamentos(
            @RequestParam(required = false) String nombre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "40") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return iParametricasService.getDepartamentos(nombre, pageable);
    }

    @GetMapping("/municipios")
    public Page<MunicipioDTO> getMunicipios(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String nombreDepartamento,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "200") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return iParametricasService.getMunicipios(nombre, nombreDepartamento, pageable);
    }

    @GetMapping("/tipoPlan")
    public List<ParametricaDTO> getTipoPlan() {
        return iParametricasService.getTipoPlan();
    }

    @GetMapping("/lineaPrincipal")
    public List<ParametricaDTO> getLineaPrincipal() {
        return iParametricasService.getLineaPrincipal();
    }

    @GetMapping("/lineaPlanTipo")
    public List<ParametricaDTO> getLineaPlanTipo() {
        return iParametricasService.getLineaPlanTipo();
    }

    @GetMapping("/tipoInsumo")
    public List<ParametricaDTO> getTipoInsumo() {
        return iParametricasService.getTipoInsumo();
    }

    @GetMapping("/unidad")
    public List<ParametricaDTO> getUnidad() {
        return iParametricasService.getUnidad();
    }
}

