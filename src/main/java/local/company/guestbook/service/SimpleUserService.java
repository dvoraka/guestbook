package local.company.guestbook.service;

import local.company.guestbook.dao.UserDAO;
import local.company.guestbook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.List;

@Service
@Transactional
public class SimpleUserService implements UserService {

    private static final int RANDOM_USERNAME_LENGTH = 10;

    @Autowired
    private UserDAO userDAO;

    @Override
    public long count() {

        return userDAO.count();
    }

    @Override
    public List<User> getUsers() {

        return userDAO.getUsers();
    }

    @Override
    public void addRandomUser() {

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int i = 0; i < RANDOM_USERNAME_LENGTH; i++) {

            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randStr = sb.toString();

        userDAO.addUser(randStr);
    }

    @Override
    public User getUser(Long userId) {

        User user = userDAO.get(userId);

        return user;
    }

    @Override
    public List<User> getUsersByName(String name) {

        List<User> users = userDAO.getByName(name);

        return users;
    }

    @Override
    public void deleteUser(long id) {

        userDAO.deleteUser(id);
    }

    @Override
    public void addUser(String username) {

        userDAO.addUser(username);
    }
}
