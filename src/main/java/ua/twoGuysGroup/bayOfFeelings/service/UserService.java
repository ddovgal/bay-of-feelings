package ua.twoGuysGroup.bayOfFeelings.service;


import ua.twoGuysGroup.bayOfFeelings.entity.User;
import ua.twoGuysGroup.bayOfFeelings.service.general.GeneralService;
import ua.twoGuysGroup.bayOfFeelings.service.general.PageableAccessService;

public interface UserService extends GeneralService<User, Long>, PageableAccessService<User> {
    //User getById(Long id);

    User getByLogin(String login);

    //User save(User user);

    User replace(User newUser, Long id);

    //void deleteById(Long id);

    //void delete(User user);

    User setAvatar(byte[] avatar, Long id);

    User incrementRatio(Long id);

    User decrementRatio(Long id);

    User addPostToFavourites(Long postId, Long userId);

    User removePostFromFavourites(Long postId, Long userId);

    User subscribeTo(Long directionId, Long userId);

    User unsubscribeFrom(Long directionId, Long userId);

    User changePassword(String newPassword, Long userId);

    User changeEmail(String newEmail, Long userId);

    //Page<User> getPageBySpecification(List<Specification<User>> specification, Boolean conjunction, Pageable pageable);
}
