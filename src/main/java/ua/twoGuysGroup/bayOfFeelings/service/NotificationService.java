package ua.twoGuysGroup.bayOfFeelings.service;

import ua.twoGuysGroup.bayOfFeelings.entity.Notification;

public interface NotificationService {
    Notification getById(Long id);

    Notification save(Notification notification);

    Notification save(Notification notification,
                      String type,
                      Long receiverId,
                      Long postId,
                      Long commentaryId,
                      Long userId
    );

    void deleteById(Long id);
}
