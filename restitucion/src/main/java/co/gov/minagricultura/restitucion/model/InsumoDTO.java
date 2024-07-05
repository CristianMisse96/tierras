package co.gov.minagricultura.restitucion.model;

public class InsumoDTO {

    private Integer id;
    private DepartamentoDTO departamento;
    private ParametricaDTO tipoPlan;
    private ParametricaDTO lineaPrincipal;
    private ParametricaDTO lineaPlanTipo;
    private ParametricaDTO unidad;
    private ParametricaDTO tipoInsumo;
    private String descripcion;
    private Double costo;
    private Double precioBase;
    private Double precioTecho;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }

    public ParametricaDTO getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(ParametricaDTO tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public ParametricaDTO getLineaPrincipal() {
        return lineaPrincipal;
    }

    public void setLineaPrincipal(ParametricaDTO lineaPrincipal) {
        this.lineaPrincipal = lineaPrincipal;
    }

    public ParametricaDTO getLineaPlanTipo() {
        return lineaPlanTipo;
    }

    public void setLineaPlanTipo(ParametricaDTO lineaPlanTipo) {
        this.lineaPlanTipo = lineaPlanTipo;
    }

    public ParametricaDTO getUnidad() {
        return unidad;
    }

    public void setUnidad(ParametricaDTO unidad) {
        this.unidad = unidad;
    }

    public ParametricaDTO getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(ParametricaDTO tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Double getPrecioTecho() {
        return precioTecho;
    }

    public void setPrecioTecho(Double precioTecho) {
        this.precioTecho = precioTecho;
    }
}

