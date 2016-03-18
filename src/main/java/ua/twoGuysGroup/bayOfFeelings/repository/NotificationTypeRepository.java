package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.NotificationType;

@Repository
public interface NotificationTypeRepository extends JpaRepository<NotificationType, String> {


}
