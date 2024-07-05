package co.gov.minagricultura.restitucion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "insumo")
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private DepartamentoEntity departamento;

    @ManyToOne
    @JoinColumn(name = "tipo_plan_id")
    private TipoPlan tipoPlan;

    @ManyToOne
    @JoinColumn(name = "linea_principal_id")
    private LineaPrincipal lineaPrincipal;

    @ManyToOne
    @JoinColumn(name = "linea_plan_tipo_id")
    private LineaPlanTipo lineaPlanTipo;

    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private Unidad unidad;

    @ManyToOne
    @JoinColumn(name = "tipo_insumo_id")
    private TipoInsumo tipoInsumo;

    @Column(length = 500)
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

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
    }

    public TipoPlan getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(TipoPlan tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public LineaPrincipal getLineaPrincipal() {
        return lineaPrincipal;
    }

    public void setLineaPrincipal(LineaPrincipal lineaPrincipal) {
        this.lineaPrincipal = lineaPrincipal;
    }

    public LineaPlanTipo getLineaPlanTipo() {
        return lineaPlanTipo;
    }

    public void setLineaPlanTipo(LineaPlanTipo lineaPlanTipo) {
        this.lineaPlanTipo = lineaPlanTipo;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public TipoInsumo getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(TipoInsumo tipoInsumo) {
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

