package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.Addition;

@Repository
public interface AdditionRepository extends CrudRepository<Addition, Long> {


}
