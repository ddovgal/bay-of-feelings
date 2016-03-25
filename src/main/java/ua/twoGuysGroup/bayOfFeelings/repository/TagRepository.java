package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {



}
