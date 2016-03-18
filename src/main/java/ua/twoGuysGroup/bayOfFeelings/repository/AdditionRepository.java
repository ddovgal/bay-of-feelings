package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.Addition;

@Repository
public interface AdditionRepository extends JpaRepository<Addition, Long> {


}
