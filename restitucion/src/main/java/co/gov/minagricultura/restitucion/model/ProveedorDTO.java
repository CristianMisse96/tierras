package co.gov.minagricultura.restitucion.model;


import java.util.List;

public class ProveedorDTO {
    private Long id;
    private String nit;
    private String razonSocial;
    private String municipio;
    private String direccion;
    private String telefono;
    private String fax;
    private String celular;
    private String correoElectronico;
    private String paginaWeb;
    private String codigoCIIU;
    private String nombreActividadEconomica;
    private String fechaConstitucion;
    private String estadoEmpresa;
    private String nroResolFacturaElectronica;
    private String tiempoSostenimientoOferta;
    private String lugarEntregaProducto;
    private String nombreRepresentanteLegal;
    private String numeroRut;
    private String fechaActualizacionRut;
    private String tipoProveedor;
    private String tipoSociedadMercantil;
    //Datos Banco
    private String nombreBanco;
    private String nombreBeneficiario;
    private String numeroCuenta;
    //Datos Camara de Comercio
    private String numeroMatriculaMercantil;
    private String fechaMatriculaMercantil;
    private String fechaRenovacionMatriculaMercantil;

    private List<Long> insumoIds;

    private List<DocumentoDTO> documentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getCodigoCIIU() {
        return codigoCIIU;
    }

    public void setCodigoCIIU(String codigoCIIU) {
        this.codigoCIIU = codigoCIIU;
    }

    public String getNombreActividadEconomica() {
        return nombreActividadEconomica;
    }

    public void setNombreActividadEconomica(String nombreActividadEconomica) {
        this.nombreActividadEconomica = nombreActividadEconomica;
    }

    public String getFechaConstitucion() {
        return fechaConstitucion;
    }

    public void setFechaConstitucion(String fechaConstitucion) {
        this.fechaConstitucion = fechaConstitucion;
    }

    public String getEstadoEmpresa() {
        return estadoEmpresa;
    }

    public void setEstadoEmpresa(String estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa;
    }

    public String getNroResolFacturaElectronica() {
        return nroResolFacturaElectronica;
    }

    public void setNroResolFacturaElectronica(String nroResolFacturaElectronica) {
        this.nroResolFacturaElectronica = nroResolFacturaElectronica;
    }

    public String getTiempoSostenimientoOferta() {
        return tiempoSostenimientoOferta;
    }

    public void setTiempoSostenimientoOferta(String tiempoSostenimientoOferta) {
        this.tiempoSostenimientoOferta = tiempoSostenimientoOferta;
    }

    public String getLugarEntregaProducto() {
        return lugarEntregaProducto;
    }

    public void setLugarEntregaProducto(String lugarEntregaProducto) {
        this.lugarEntregaProducto = lugarEntregaProducto;
    }

    public String getNombreRepresentanteLegal() {
        return nombreRepresentanteLegal;
    }

    public void setNombreRepresentanteLegal(String nombreRepresentanteLegal) {
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
    }

    public List<Long> getInsumoIds() {
        return insumoIds;
    }

    public void setInsumoIds(List<Long> insumoIds) {
        this.insumoIds = insumoIds;
    }

    public List<DocumentoDTO> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoDTO> documentos) {
        this.documentos = documentos;
    }

    public String getNumeroRut() {
        return numeroRut;
    }

    public void setNumeroRut(String numeroRut) {
        this.numeroRut = numeroRut;
    }

    public String getFechaActualizacionRut() {
        return fechaActualizacionRut;
    }

    public void setFechaActualizacionRut(String fechaActualizacionRut) {
        this.fechaActualizacionRut = fechaActualizacionRut;
    }

    public String getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(String tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }

    public String getTipoSociedadMercantil() {
        return tipoSociedadMercantil;
    }

    public void setTipoSociedadMercantil(String tipoSociedadMercantil) {
        this.tipoSociedadMercantil = tipoSociedadMercantil;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroMatriculaMercantil() {
        return numeroMatriculaMercantil;
    }

    public void setNumeroMatriculaMercantil(String numeroMatriculaMercantil) {
        this.numeroMatriculaMercantil = numeroMatriculaMercantil;
    }

    public String getFechaMatriculaMercantil() {
        return fechaMatriculaMercantil;
    }

    public void setFechaMatriculaMercantil(String fechaMatriculaMercantil) {
        this.fechaMatriculaMercantil = fechaMatriculaMercantil;
    }

    public String getFechaRenovacionMatriculaMercantil() {
        return fechaRenovacionMatriculaMercantil;
    }

    public void setFechaRenovacionMatriculaMercantil(String fechaRenovacionMatriculaMercantil) {
        this.fechaRenovacionMatriculaMercantil = fechaRenovacionMatriculaMercantil;
    }
}

