package local.company.guestbook;

import java.util.List;

public interface GuestbookService {

    List<User> getUsers();
    List<Comment> getComments();

}
