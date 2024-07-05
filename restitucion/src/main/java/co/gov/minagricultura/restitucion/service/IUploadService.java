package co.gov.minagricultura.restitucion.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import co.gov.minagricultura.restitucion.entity.Documento;

public interface IUploadService {
	
	public String copiar(MultipartFile archivo,  String directorio, Documento documento) throws IOException;
	public boolean eliminar (String nombreFoto,  String directorio) throws IOException;
}
