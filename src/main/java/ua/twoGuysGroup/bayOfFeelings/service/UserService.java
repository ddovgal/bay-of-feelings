package ua.twoGuysGroup.bayOfFeelings.service;


import ua.twoGuysGroup.bayOfFeelings.entity.User;

public interface UserService {
    User getById(Long id);

    User getByLogin(String login);

    User save(User user);

    User replace(User newUser, Long id);

    void deleteById(Long id);

    void delete(User user);

    User setAvatar(byte[] avatar, Long id);

    User incrementRatio(Long id);

    User decrementRatio(Long id);

    User addPostToFavourites(Long postId, Long userId);

    User removePostFromFavourites(Long postId, Long userId);

    User subscribeTo(Long directionId, Long userId);

    User unsubscribeFrom(Long directionId, Long userId);

    User changePassword(String newPassword, Long userId);

    User changeEmail(String newEmail, Long userId);
}
