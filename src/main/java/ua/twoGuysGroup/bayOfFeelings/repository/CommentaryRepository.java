package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.Commentary;

@Repository
public interface CommentaryRepository extends CrudRepository<Commentary, Long>,
        PagingAndSortingRepository<Commentary, Long> {



}
