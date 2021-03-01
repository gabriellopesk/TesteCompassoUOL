package com.compassoUol.testCompassoUol.repositories.specifications;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.compassoUol.testCompassoUol.models.Product;
import com.compassoUol.testCompassoUol.models.Product_;

public class ProductSpecification {


    public static Specification<Product> Productfilter(String q, BigDecimal min_price, BigDecimal max_price) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasText(q)){
            	Predicate namePredicate = criteriaBuilder.equal(root.get(Product_.name) , q);
                Predicate descriptionPredicate = criteriaBuilder.equal(root.get(Product_.description) , q);
            	predicates.add(criteriaBuilder.or(namePredicate, descriptionPredicate));
            }
            if(!ObjectUtils.isEmpty(min_price)) {
            	predicates.add(criteriaBuilder.ge(root.get(Product_.price) , min_price));
            }
            if(!ObjectUtils.isEmpty(max_price)) {
            	predicates.add(criteriaBuilder.le(root.get(Product_.price) , max_price));
            }
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

}
