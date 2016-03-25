package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {


}
