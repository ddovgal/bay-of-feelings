package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.PostCategory;

@Repository
public interface PostCategoryRepository extends CrudRepository<PostCategory, String> {


}
