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

    void addRandomUser();

}
