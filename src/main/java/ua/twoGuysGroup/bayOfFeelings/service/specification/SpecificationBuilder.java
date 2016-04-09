package ua.twoGuysGroup.bayOfFeelings.service.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpecificationBuilder<T> {

    private List<Specification<T>> specifications;

    public SpecificationBuilder() {
        specifications = new ArrayList<>();
    }

    public SpecificationBuilder(List<Specification<T>> specifications) {
        this.specifications = specifications;
    }

    public void addSpecification(Specification<T> specification) {
        specifications.add(specification);
    }

    public Specification<T> buildByConjunction() {
        if (specifications.isEmpty()) return null;

        Specification<T> result = specifications.get(0);
        for (Specification<T> spec : specifications) result = Specifications.where(result).and(spec);
        return result;
    }

    public Specification<T> buildByDisjunction() {
        if (specifications.isEmpty()) return null;

        Specification<T> result = specifications.get(0);
        for (Specification<T> spec : specifications) result = Specifications.where(result).or(spec);
        return result;
    }

}