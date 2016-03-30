package ua.twoGuysGroup.bayOfFeelings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.twoGuysGroup.bayOfFeelings.entity.Notification;
import ua.twoGuysGroup.bayOfFeelings.repository.*;
import ua.twoGuysGroup.bayOfFeelings.service.NotificationService;

@Service
@Transactional
public class NotificationServiceSpringDataImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private NotificationTypeRepository notificationTypeRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentaryRepository commentaryRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Notification getById(Long id) {
        return notificationRepository.findOne(id);
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification save(Notification notification,
                             String type,
                             Long receiverId,
                             Long postId,
                             Long commentaryId,
                             Long userId
    ) {
        notification.setType(notificationTypeRepository.findOne(type));
        notification.setReceiver(userRepository.findOne(receiverId));
        if (postId != null) notification.setCausePost(postRepository.findOne(postId));
        else if (commentaryId != null) notification.setCauseCommentary(commentaryRepository.findOne(commentaryId));
        else if (userId != null) notification.setCauseUser(userRepository.findOne(userId));
        return save(notification);
    }

    @Override
    public void deleteById(Long id) {
        notificationRepository.delete(id);
    }
}
