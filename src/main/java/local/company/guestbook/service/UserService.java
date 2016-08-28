package local.company.guestbook.service;

import local.company.guestbook.model.User;

import java.util.List;

/**
 * Service layer for UserDAO.
 *
 * @author dvoraka
 */
public interface UserService {

    long count();

    List<User> getUsers();

    User getUser(Long userId);

    List<User> getUsersByName(String name);

    void addUser(String username);

    void addUser(User user);

    void addRandomUser();

    void deleteUser(long id);

}
