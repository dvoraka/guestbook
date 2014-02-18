package local.company.guestbook;

import java.util.List;

public interface UserDAO {
    
    long count();
    List<User> getUsers();
    
}
