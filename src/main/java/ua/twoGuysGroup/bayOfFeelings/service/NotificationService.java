package ua.twoGuysGroup.bayOfFeelings.service;

import ua.twoGuysGroup.bayOfFeelings.entity.Notification;
import ua.twoGuysGroup.bayOfFeelings.service.general.GeneralService;

public interface NotificationService extends GeneralService<Notification, Long> {
    //Notification getById(Long id);

    //Notification save(Notification notification);

    Notification save(Notification notification,
                      String type,
                      Long receiverId,
                      Long postId,
                      Long commentaryId,
                      Long userId
    );

    //void deleteById(Long id);
}
