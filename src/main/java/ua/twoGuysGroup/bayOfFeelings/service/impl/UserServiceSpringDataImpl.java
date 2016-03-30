package ua.twoGuysGroup.bayOfFeelings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.twoGuysGroup.bayOfFeelings.entity.Post;
import ua.twoGuysGroup.bayOfFeelings.entity.User;
import ua.twoGuysGroup.bayOfFeelings.repository.PostRepository;
import ua.twoGuysGroup.bayOfFeelings.repository.UserRepository;
import ua.twoGuysGroup.bayOfFeelings.service.UserService;

import java.util.Date;
import java.util.Set;

@Service
@Transactional
public class UserServiceSpringDataImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;


    @Override
    public User getById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.getByLogin(login);
    }

    private User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        user.setRegistrationDate(new Date());
        return update(user);
    }

    @Override
    public User replace(User newUser, Long id) {
        newUser.setId(id); //todo unchecked
        return save(newUser);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User setAvatar(byte[] avatar, Long id) {
        User user = userRepository.findOne(id);
        user.setAvatar(avatar);
        return update(user);
    }

    @Override
    public User addPostToFavourites(Long postId, Long userId) {
        User user = userRepository.findOne(userId);
        Set<Post> favPosts = user.getFavouritePosts();
        favPosts.add(postRepository.findOne(postId));
        return update(user);
    }

    @Override
    public User removePostFromFavourites(Long postId, Long userId) {
        User user = userRepository.findOne(userId);
        Set<Post> favPosts = user.getFavouritePosts();
        favPosts.remove(postRepository.findOne(postId));
        return update(user);
    }

    @Override
    public User subscribeTo(Long directionId, Long userId) {
        User user = userRepository.findOne(userId);
        Set<User> favouriteUsers = user.getSubscriptionsToUsers();
        favouriteUsers.add(userRepository.findOne(directionId));
        return update(user);
    }

    @Override
    public User unsubscribeFrom(Long directionId, Long userId) {
        User user = userRepository.findOne(userId);
        Set<User> favouriteUsers = user.getSubscriptionsToUsers();
        favouriteUsers.remove(userRepository.findOne(directionId));
        return update(user);
    }

    private User changeRatio(Long id, int value) {
        User user = getById(id);
        user.setRatio(user.getRatio() + value);
        return update(user);
    }

    @Override
    public User incrementRatio(Long id) {
        return changeRatio(id, 1);
    }

    @Override
    public User decrementRatio(Long id) {
        return changeRatio(id, -1);
    }

    @Override
    public User changePassword(String newPassword, Long userId) {
        User user = getById(userId);
        user.setPassword(newPassword);
        return update(user);
    }

    @Override
    public User changeEmail(String newEmail, Long userId) {
        User user = getById(userId);
        user.setEmail(newEmail);
        return update(user);
    }
}
