package co.gov.minagricultura.restitucion.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.gov.minagricultura.restitucion.entity.Documento;
import co.gov.minagricultura.restitucion.service.IUploadService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UploadServiceImpl implements IUploadService {

	@Override
	public String copiar(MultipartFile archivo, String directorio, Documento doc) throws IOException {
		
		String nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
        Path rutaArchivo = getPath(nombreArchivo, directorio);
        //log.info(rutaArchivo.toString());
        doc.setRutaArchivo(rutaArchivo.toString());
        Files.createDirectories(rutaArchivo.getParent());
        Files.copy(archivo.getInputStream(), rutaArchivo);

        return nombreArchivo;
	}

	@Override
	public boolean eliminar(String nombreFoto, String directorio) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Path getPath(String nombreFoto, String directorio) {
        return Paths.get(directorio, nombreFoto).toAbsolutePath();
    }

}
