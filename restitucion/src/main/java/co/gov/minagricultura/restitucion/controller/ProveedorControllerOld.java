package co.gov.minagricultura.restitucion.controller;

import co.gov.minagricultura.restitucion.model.ProveedorDTO;
import co.gov.minagricultura.restitucion.model.ProveedorResponseDTO;
import co.gov.minagricultura.restitucion.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/proveedor")
public class ProveedorControllerOld {

    @Autowired
    private IProveedorService iProveedorService;

    @PostMapping
    public ResponseEntity<ProveedorResponseDTO> crearProveedor(@RequestBody ProveedorDTO proveedorDTO){
        var proveedor = iProveedorService.crearProveedor(proveedorDTO);
        return ResponseEntity.ok(proveedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponseDTO> obtenerProveedor(@PathVariable Long id){
        return ResponseEntity.ok(iProveedorService.obtenerProveedor(id));
    }

    @GetMapping
    public Page<ProveedorResponseDTO> filtrarProveedores(@RequestParam(required = false) String nit,
                                                 @RequestParam(required = false) String razonSocial,
                                                 @RequestParam(required = false) String municipio,
                                                 @RequestParam(required = false) String lugarEntregaProducto,
                                                 @RequestParam(required = false) String nombreRepresentanteLegal,
                                                 @RequestParam(required = false) String nombreActividadEconomica,
                                                 @RequestParam(required = false) String codigoCIIU,
                                                 @RequestParam(required = false) String nombreInsumo,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return iProveedorService.filtrarProveedores(nit, razonSocial, municipio, lugarEntregaProducto, nombreRepresentanteLegal, nombreActividadEconomica, codigoCIIU, nombreInsumo, pageable);
    }
}
