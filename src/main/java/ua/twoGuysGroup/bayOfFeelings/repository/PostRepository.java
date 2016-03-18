package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>,
        PagingAndSortingRepository<Post, Long> {



}
