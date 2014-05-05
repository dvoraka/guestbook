package local.company.guestbook;

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

    void addRandomUser();

    void deleteUser(long id);

}
