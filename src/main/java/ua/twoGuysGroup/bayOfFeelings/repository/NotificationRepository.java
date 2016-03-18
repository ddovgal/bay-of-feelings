package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {


}
