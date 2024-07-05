package co.gov.minagricultura.restitucion.controller;

import co.gov.minagricultura.restitucion.entity.Documento;
import co.gov.minagricultura.restitucion.model.ProveedorDTO;
import co.gov.minagricultura.restitucion.model.ProveedorResponseDTO;
import co.gov.minagricultura.restitucion.service.impl.ProveedorService;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/proveedores")
public class ProveedorController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProveedorController.class);
    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<ProveedorResponseDTO> createProveedor(@ModelAttribute ProveedorDTO proveedorDTO,
    		@RequestParam("archivoRut") MultipartFile archivoRut) {
    	logger.info("esto me llega de angular" + proveedorDTO.toString());
        try {
            ProveedorResponseDTO proveedor = proveedorService.saveProveedor(proveedorDTO,archivoRut);
            return new ResponseEntity<>(proveedor, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{proveedorId}/documentos/{documentoId}")
    public ResponseEntity<ByteArrayResource> getFile(@PathVariable Long proveedorId, @PathVariable Long documentoId) {
        try {
            Documento documento = proveedorService.getDocumento(proveedorId, documentoId);
            byte[] file = proveedorService.getFile(documento.getRutaArchivo());
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documento.getNombreArchivo() + "\"")
                    .body(new ByteArrayResource(file));
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorResponseDTO> updateProveedor(@PathVariable Long id, @RequestBody ProveedorDTO proveedorDTO) {
        try {
            ProveedorResponseDTO proveedor = proveedorService.updateProveedor(id, proveedorDTO);
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        try {
            proveedorService.deleteProveedor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponseDTO> obtenerProveedor(@PathVariable Long id){
        return ResponseEntity.ok(proveedorService.obtenerProveedor(id));
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
        return proveedorService.filtrarProveedores(nit, razonSocial, municipio, lugarEntregaProducto, nombreRepresentanteLegal, nombreActividadEconomica, codigoCIIU, nombreInsumo, pageable);
    }
}
