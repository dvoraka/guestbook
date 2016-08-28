package local.company.guestbook.service;

import local.company.guestbook.model.User;
import local.company.guestbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DefaultUserService implements UserService {

    private static final int RANDOM_USERNAME_LENGTH = 10;

    @Autowired
    private UserRepository userRepository;


    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
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

        userRepository.save(createUser(randStr));
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.delete(id);
    }

    @Override
    public void addUser(String username) {
        userRepository.save(createUser(username));
    }

    private User createUser(String username) {
        User user = new User();
        user.setUsername(username);
        user.setCreated(new Date());

        return user;
    }
}
