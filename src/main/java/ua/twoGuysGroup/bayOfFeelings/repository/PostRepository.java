package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>,
        PagingAndSortingRepository<Post, Long> {



}
