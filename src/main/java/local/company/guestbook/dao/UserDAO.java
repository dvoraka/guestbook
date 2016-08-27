package local.company.guestbook.dao;

import local.company.guestbook.model.User;

import java.util.List;

public interface UserDAO {

    long count();

    List<User> getUsers();

    Long addUser(String name);

    void deleteUser(long id);

    User get(Long id);

    List<User> getByName(String name);
}
