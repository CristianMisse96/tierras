package co.gov.minagricultura.restitucion.service.impl;

import co.gov.minagricultura.restitucion.entity.Documento;
import co.gov.minagricultura.restitucion.entity.Insumo;
import co.gov.minagricultura.restitucion.entity.ProveedorEntity;
import co.gov.minagricultura.restitucion.entity.ProveedorInsumo;
import co.gov.minagricultura.restitucion.mapper.ProveedorMapper;
import co.gov.minagricultura.restitucion.model.DocumentoDTO;
import co.gov.minagricultura.restitucion.model.ProveedorDTO;
import co.gov.minagricultura.restitucion.model.ProveedorResponseDTO;
import co.gov.minagricultura.restitucion.repository.DocumentoRepository;
import co.gov.minagricultura.restitucion.repository.InsumoRepository;
import co.gov.minagricultura.restitucion.repository.ProveedorInsumoRepository;
import co.gov.minagricultura.restitucion.repository.ProveedorRepository;
import co.gov.minagricultura.restitucion.service.IProveedorService;
import co.gov.minagricultura.restitucion.service.IUploadService;
import co.gov.minagricultura.restitucion.specification.ProveedorSpecifications;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProveedorService implements IProveedorService {

    private static final Logger logger = LoggerFactory.getLogger(ProveedorService.class);

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorInsumoRepository proveedorInsumoRepository;

    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private DocumentoRepository documentoRepository;
    
    @Autowired
    private IUploadService iUploadService;

    @Value("${file.upload-dir}")
    private String uploadDir;


    @Override
    public ProveedorResponseDTO crearProveedor(ProveedorDTO proveedorDTO) {
        var proveedor = proveedorRepository.save(ProveedorMapper.INSTANCE.dtoToEntity(proveedorDTO));

        proveedorInsumoRepository.deleteByProveedor(proveedor);
        if (proveedorDTO.getInsumoIds() != null) {
            for (Long insumoId : proveedorDTO.getInsumoIds()) {
                Insumo insumo = insumoRepository.findById(insumoId).orElseThrow(() -> new RuntimeException("Insumo no encontrado"));
                ProveedorInsumo proveedorInsumo = new ProveedorInsumo();
                proveedorInsumo.setProveedor(proveedor);
                proveedorInsumo.setInsumo(insumo);
                proveedorInsumoRepository.save(proveedorInsumo);
            }
        }

        return ProveedorMapper.INSTANCE.toResponseDTO(proveedor);
    }

    @Override
    public ProveedorResponseDTO obtenerProveedor(Long id) {
        var proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        return ProveedorMapper.INSTANCE.toResponseDTO(proveedor);
    }

    @Override
    public Page<ProveedorResponseDTO> filtrarProveedores(String nit, String razonSocial, String municipio, String lugarEntregaProducto, String nombreRepresentanteLegal, String nombreActividadEconomica, String codigoCIIU, String nombreInsumo, Pageable pageable) {
        Specification<ProveedorEntity> spec = ProveedorSpecifications.getProveedorEntitySpecification(nit, razonSocial, municipio, lugarEntregaProducto, nombreRepresentanteLegal, nombreActividadEconomica, codigoCIIU, nombreInsumo);
        return proveedorRepository.findAll(spec, pageable).map(ProveedorMapper.INSTANCE::toResponseDTO);
    }

    public ProveedorResponseDTO saveProveedor(ProveedorDTO proveedorDTO, MultipartFile archivoRut) throws IOException {
        ProveedorEntity proveedor = ProveedorMapper.INSTANCE.dtoToEntity(proveedorDTO);
        //proveedor.setDocumentos(null);
        

        /*List<Documento> documentos = new ArrayList<>();
        String timestamp = String.valueOf(System.currentTimeMillis());
        for (DocumentoDTO docDTO : proveedorDTO.getDocumentos()) {
            Documento documento = new Documento();
            documento.setTipo(docDTO.getTipo());
            documento.setNombreArchivo(docDTO.getNombreArchivo());

            // Crear la estructura de carpetas por idProveedor y timestamp

            String filePath = uploadDir + File.separator + proveedorGuardado.getId() + File.separator + timestamp + File.separator + docDTO.getNombreArchivo();
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Crear directorios si no existen
            Files.write(file.toPath(), docDTO.getArchivo());

            documento.setRutaArchivo(filePath);
            documento.setProveedor(proveedorGuardado);
            documentos.add(documento);

            // Log de la ruta del archivo
            logger.info("Archivo guardado en: " + filePath);
        }
        var documentosGuardados = documentoRepository.saveAll(documentos);
        proveedorGuardado.setDocumentos(documentosGuardados);*/
        List<Documento> documentos = new ArrayList<Documento>();
        
        if(!archivoRut.isEmpty()) {
        	Documento documento = new Documento();
        	documento.setNombreArchivo(iUploadService.copiar(archivoRut, "uploads/documentosProveedores/rut",documento));
        	documento.setTipo("RUT");
        	documentos.add(documento);
        }
        
        proveedor.setDocumentos(documentos);
        ProveedorEntity proveedorGuardado = proveedorRepository.save(proveedor);

        proveedorInsumoRepository.deleteByProveedor(proveedorGuardado);
        if (proveedorDTO.getInsumoIds() != null) {
            for (Long insumoId : proveedorDTO.getInsumoIds()) {
                Insumo insumo = insumoRepository.findById(insumoId).orElseThrow(() -> new RuntimeException("Insumo no encontrado"));
                ProveedorInsumo proveedorInsumo = new ProveedorInsumo();
                proveedorInsumo.setProveedor(proveedorGuardado);
                proveedorInsumo.setInsumo(insumo);
                proveedorInsumoRepository.save(proveedorInsumo);
            }
        }

        return ProveedorMapper.INSTANCE.toResponseDTO(proveedorGuardado);
    }

    public Documento getDocumento(Long proveedorId, Long documentoId) throws FileNotFoundException {
        return documentoRepository.findByIdAndProveedorId(documentoId, proveedorId)
                .orElseThrow(() -> new FileNotFoundException("Documento no encontrado"));
    }

    public byte[] getFile(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }


    public ProveedorResponseDTO updateProveedor(Long id, ProveedorDTO proveedorDTO) throws IOException {
        ProveedorEntity proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proveedor no encontrado"));

        // Actualizar los campos del proveedor
        proveedor.setNit(proveedorDTO.getNit());
        proveedor.setRazonSocial(proveedorDTO.getRazonSocial());
        proveedor.setMunicipio(proveedorDTO.getMunicipio());
        proveedor.setDireccion(proveedorDTO.getDireccion());
        proveedor.setTelefono(proveedorDTO.getTelefono());

        // Manejar los documentos
        List<Documento> documentos = new ArrayList<>();
        String timestamp = String.valueOf(System.currentTimeMillis());
        for (DocumentoDTO docDTO : proveedorDTO.getDocumentos()) {
            Documento documento = new Documento();
            documento.setTipo(docDTO.getTipo());
            documento.setNombreArchivo(docDTO.getNombreArchivo());
            // Crear la estructura de carpetas por idProveedor y timestamp

            String filePath = uploadDir + File.separator + proveedor.getId() + File.separator + timestamp + File.separator + docDTO.getNombreArchivo();
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Crear directorios si no existen
            Files.write(file.toPath(), docDTO.getArchivo());

            documento.setRutaArchivo(filePath);
            documento.setProveedor(proveedor);
            documentos.add(documento);

            // Log de la ruta del archivo
            logger.info("Archivo guardado en: " + filePath);
        }
        var documentosGuardados = documentoRepository.saveAll(documentos);
        proveedor.setDocumentos(documentosGuardados);

        return ProveedorMapper.INSTANCE.toResponseDTO(proveedorRepository.save(proveedor));
    }

    public void deleteProveedor(Long id) {
        if (!proveedorRepository.existsById(id)) {
            throw new EntityNotFoundException("Proveedor no encontrado");
        }
        proveedorRepository.deleteById(id);
    }
}
