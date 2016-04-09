package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.Post;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long>,
        JpaSpecificationExecutor<Post> {



}
