package co.gov.minagricultura.restitucion.specification;

import co.gov.minagricultura.restitucion.entity.Insumo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class InsumoSpecification implements Specification<Insumo> {
    private String departamentoNombre;
    private String tipoPlanNombre;
    private String lineaPrincipalNombre;
    private String lineaPlanTipoNombre;
    private String unidadNombre;
    private String insumo;
    private String descripcion;
    private Double costo;
    private Double precioBase;
    private Double precioTecho;

    public InsumoSpecification(String departamentoNombre, String tipoPlanNombre, String lineaPrincipalNombre, String lineaPlanTipoNombre, String unidadNombre, String insumo, String descripcion, Double costo, Double precioBase, Double precioTecho) {
        this.departamentoNombre = departamentoNombre;
        this.tipoPlanNombre = tipoPlanNombre;
        this.lineaPrincipalNombre = lineaPrincipalNombre;
        this.lineaPlanTipoNombre = lineaPlanTipoNombre;
        this.unidadNombre = unidadNombre;
        this.insumo = insumo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precioBase = precioBase;
        this.precioTecho = precioTecho;
    }

    @Override
    public Predicate toPredicate(Root<Insumo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (departamentoNombre != null && !departamentoNombre.isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("departamento").get("nombre")), "%" + departamentoNombre.toLowerCase() + "%"));
        }
        if (tipoPlanNombre != null && !tipoPlanNombre.isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("tipoPlan").get("nombre")), "%" + tipoPlanNombre.toLowerCase() + "%"));
        }
        if (lineaPrincipalNombre != null && !lineaPrincipalNombre.isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("lineaPrincipal").get("nombre")), "%" + lineaPrincipalNombre.toLowerCase() + "%"));
        }
        if (lineaPlanTipoNombre != null && !lineaPlanTipoNombre.isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("lineaPlanTipo").get("nombre")), "%" + lineaPlanTipoNombre.toLowerCase() + "%"));
        }
        if (unidadNombre != null && !unidadNombre.isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("unidad").get("nombre")), "%" + unidadNombre.toLowerCase() + "%"));
        }
        if (insumo != null && !insumo.isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("tipoInsumo").get("nombre")), "%" + insumo.toLowerCase() + "%"));
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("descripcion")), "%" + descripcion.toLowerCase() + "%"));
        }
        if (costo != null) {
            predicates.add(criteriaBuilder.equal(root.get("costo"), costo));
        }
        if (precioBase != null) {
            predicates.add(criteriaBuilder.equal(root.get("precioBase"), precioBase));
        }
        if (precioTecho != null) {
            predicates.add(criteriaBuilder.equal(root.get("precioTecho"), precioTecho));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}

