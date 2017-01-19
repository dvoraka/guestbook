package local.company.guestbook.service;

import local.company.guestbook.model.Author;

import java.util.List;

/**
 * Service layer for User repository.
 *
 * @author dvoraka
 */
public interface UserService {

    long count();

    List<Author> getUsers();

    Author getUser(Long userId);

    List<Author> getUsersByName(String name);

    void addUser(String username);

    void addUser(Author author);

    void addRandomUser();

    void deleteUser(long id);
}
