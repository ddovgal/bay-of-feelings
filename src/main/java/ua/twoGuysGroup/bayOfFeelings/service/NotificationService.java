package ua.twoGuysGroup.bayOfFeelings.service;

import ua.twoGuysGroup.bayOfFeelings.entity.Notification;

public interface NotificationService {
    Notification getById(Long id);

    Notification save(Notification notification);

    void deleteById(Long id);
}
