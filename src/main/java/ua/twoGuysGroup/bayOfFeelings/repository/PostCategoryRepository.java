package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.PostCategory;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory, String> {


}
