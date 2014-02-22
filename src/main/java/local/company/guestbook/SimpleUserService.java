package local.company.guestbook;

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

        throw new UnsupportedOperationException("Not supported yet.");

    }
}
