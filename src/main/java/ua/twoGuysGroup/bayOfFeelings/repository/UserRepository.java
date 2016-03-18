package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>,
        PagingAndSortingRepository<User, Long> {



}
