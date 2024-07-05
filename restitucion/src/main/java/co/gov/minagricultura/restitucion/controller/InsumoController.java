package co.gov.minagricultura.restitucion.controller;

import co.gov.minagricultura.restitucion.model.InsumoDTO;
import co.gov.minagricultura.restitucion.service.IInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/insumos")
public class InsumoController {
    @Autowired
    private IInsumoService iInsumoService;

    @GetMapping
    public List<InsumoDTO> getAll() {
        return iInsumoService.getAll();
    }

    @GetMapping("/{id}")
    public InsumoDTO getById(@PathVariable Long id) {
        return iInsumoService.getById(id);
    }

    @PostMapping
    public InsumoDTO create(@RequestBody InsumoDTO insumoDTO) {
        return iInsumoService.save(insumoDTO);
    }

    @PutMapping("/{id}")
    public InsumoDTO update(@PathVariable Integer id, @RequestBody InsumoDTO insumoDTO) {
        insumoDTO.setId(id);
        return iInsumoService.save(insumoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        iInsumoService.delete(id);
    }

    @GetMapping("/filtrar")
    public Page<InsumoDTO> filtrarInsumos(@RequestParam(required = false) String departamentoNombre,
                                          @RequestParam(required = false) String tipoPlanNombre,
                                          @RequestParam(required = false) String lineaPrincipalNombre,
                                          @RequestParam(required = false) String lineaPlanTipoNombre,
                                          @RequestParam(required = false) String unidadNombre,
                                          @RequestParam(required = false) String insumo,
                                          @RequestParam(required = false) String descripcion,
                                          @RequestParam(required = false) Double costo,
                                          @RequestParam(required = false) Double precioBase,
                                          @RequestParam(required = false) Double precioTecho,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return iInsumoService.filtrarInsumos(departamentoNombre, tipoPlanNombre, lineaPrincipalNombre, lineaPlanTipoNombre, unidadNombre, insumo, descripcion, costo, precioBase, precioTecho, pageable);
    }
}
