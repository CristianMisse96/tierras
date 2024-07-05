package co.gov.minagricultura.restitucion.specification;

import co.gov.minagricultura.restitucion.entity.Insumo;
import co.gov.minagricultura.restitucion.entity.ProveedorEntity;
import co.gov.minagricultura.restitucion.entity.ProveedorInsumo;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

public class ProveedorSpecifications {

    public static Specification<ProveedorEntity> getProveedorEntitySpecification(String nit,
                                                                                 String razonSocial,
                                                                                 String municipio,
                                                                                 String lugarEntregaProducto,
                                                                                 String nombreRepresentanteLegal,
                                                                                 String nombreActividadEconomica,
                                                                                 String codigoCIIU,
                                                                                 String nombreInsumo) {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(criteriaBuilder.lower(root.get("razonSocial"))));
            Predicate predicate = criteriaBuilder.conjunction();

            if (nit != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("nit")), "%" + nit.toLowerCase() + "%"));
            }
            if (razonSocial != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("razonSocial")), "%" + razonSocial.toLowerCase() + "%"));
            }
            if (municipio != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("municipio")), "%" + municipio.toLowerCase() + "%"));
            }
            if (lugarEntregaProducto != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("lugarEntregaProducto")), "%" + lugarEntregaProducto.toLowerCase() + "%"));
            }
            if (nombreRepresentanteLegal != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("nombreRepresentanteLegal")), "%" + nombreRepresentanteLegal.toLowerCase() + "%"));
            }
            if (nombreActividadEconomica != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("nombreActividadEconomica")), "%" + nombreActividadEconomica.toLowerCase() + "%"));
            }
            if (codigoCIIU != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("codigoCIIU")), "%" + codigoCIIU.toLowerCase() + "%"));
            }
            if (nombreInsumo != null) {
                Join<ProveedorEntity, ProveedorInsumo> insumoJoin = root.join("insumos", JoinType.LEFT);
                Join<ProveedorInsumo, Insumo> insumo = insumoJoin.join("insumo", JoinType.LEFT);
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(insumo.get("tipoInsumo").get("nombre")), "%" + nombreInsumo.toLowerCase() + "%"));
            }

            return predicate;
        };
    }
}

