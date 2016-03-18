package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.Commentary;

@Repository
public interface CommentaryRepository extends JpaRepository<Commentary, Long>,
        PagingAndSortingRepository<Commentary, Long> {



}
