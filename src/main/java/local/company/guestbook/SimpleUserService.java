package local.company.guestbook;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SimpleUserService {

    @Autowired
    private UserDAO userDAO;

    public long count() {

        return userDAO.count();

    }
    
    public List<User> getUsers() {
        
        return userDAO.getUsers();
        
    }
}
