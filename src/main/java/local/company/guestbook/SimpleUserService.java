package local.company.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SimpleUserService {

    @Autowired
    private SimpleUserDAO userDAO;

    public long count() {

        return userDAO.count();

    }
}
