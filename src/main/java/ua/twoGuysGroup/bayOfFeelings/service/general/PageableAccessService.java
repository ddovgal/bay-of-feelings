package ua.twoGuysGroup.bayOfFeelings.service.general;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface PageableAccessService<T> {
    Page<T> getPageBySpecification(List<Specification<T>> specification, Boolean conjunction, Pageable pageable);
}
