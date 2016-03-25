package ua.twoGuysGroup.bayOfFeelings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.twoGuysGroup.bayOfFeelings.entity.NotificationType;

@Repository
public interface NotificationTypeRepository extends CrudRepository<NotificationType, String> {


}
