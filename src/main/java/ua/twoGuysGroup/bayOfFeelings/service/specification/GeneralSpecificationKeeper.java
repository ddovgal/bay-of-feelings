package ua.twoGuysGroup.bayOfFeelings.service.specification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.SetJoin;
import java.util.Set;

@Component
public class GeneralSpecificationKeeper<T> {

    @Value("${const.default-page-size}")
    private Integer DEFAULT_PAGE_SIZE;

    public Specification<T> containingInString(String fieldName, String word) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get(fieldName), "%" + word + "%");
    }

    public Specification<T> inRange(String fieldName, Integer min, Integer max) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.between(root.get(fieldName), min, max);
    }

    public <S> Specification<T> being(Object object, String... fieldNamesSequence) {
        return (root, criteriaQuery, criteriaBuilder) ->
        {
            Path<T> path = root.get(fieldNamesSequence[0]);
            for (int i = 1; i < fieldNamesSequence.length; i++) {
                path = path.get(fieldNamesSequence[i]);
            }
            return criteriaBuilder.equal(path, object);
        };
    }

    public Specification<T> containingObjects(Set<Object> objects, String rootFieldName) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            //use to disable getting duplicates
            criteriaQuery.distinct(true);
            return root.joinSet(rootFieldName).in(objects);
        };
    }

    public <S> Specification<T> containingObjects(Set<Object> objects, String rootFieldName, String subFieldName) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            //use to disable getting duplicates
            criteriaQuery.distinct(true);
            SetJoin<T, S> bookGenres = root.joinSet(rootFieldName);
            return bookGenres.get(subFieldName).in(objects);
        };
    }

    //region Difficult ver of containingObjects
    /*public <S> Specification<T> containingObjects(Set<Object> objects, String rootFieldName, String... subFieldNamesSequence) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            //use to disable getting duplicates
            criteriaQuery.distinct(true);
            SetJoin<T, S> bookGenres = root.joinSet(rootFieldName);
            Path<T> subPath = bookGenres.get(subFieldNamesSequence[0]);
            for (int i = 1; i < subFieldNamesSequence.length; i++) {
                subPath = subPath.get(subFieldNamesSequence[i]);
            }
            return subPath.in(objects);
        };
    }*/
    //endregion

    public Sort creteSort(String fieldName, boolean asc) {
        return new Sort((asc ? Sort.Direction.ASC : Sort.Direction.DESC), fieldName);
    }

    public PageRequest createPageRequest(Integer page, Integer pageSize, Sort sort) {
        return new PageRequest(page, pageSize != -1 ? pageSize : DEFAULT_PAGE_SIZE, sort);
    }

}
