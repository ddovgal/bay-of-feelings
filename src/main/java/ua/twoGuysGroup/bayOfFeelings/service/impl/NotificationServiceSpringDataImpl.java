package ua.twoGuysGroup.bayOfFeelings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.twoGuysGroup.bayOfFeelings.entity.Notification;
import ua.twoGuysGroup.bayOfFeelings.repository.NotificationRepository;
import ua.twoGuysGroup.bayOfFeelings.service.NotificationService;

@Service
@Transactional
public class NotificationServiceSpringDataImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification getById(Long id) {
        return notificationRepository.findOne(id);
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void deleteById(Long id) {
        notificationRepository.delete(id);
    }
}
