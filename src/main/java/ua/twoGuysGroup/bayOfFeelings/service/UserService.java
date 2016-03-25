package ua.twoGuysGroup.bayOfFeelings.service;


import ua.twoGuysGroup.bayOfFeelings.entity.User;

public interface UserService {
    User getById(Long id);

    User getByLogin(String login);

    User save(User user);

    User replace(User newUser, Long id);

    void deleteById(Long id);

    void delete(User user);
}
