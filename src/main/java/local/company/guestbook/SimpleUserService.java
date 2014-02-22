package local.company.guestbook;

import java.security.SecureRandom;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SimpleUserService implements UserService {

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
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randStr = sb.toString();
        
        userDAO.addUser(randStr);

    }
}
