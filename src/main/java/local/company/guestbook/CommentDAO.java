package local.company.guestbook;

import java.util.List;

public interface CommentDAO {

    void add(Comment comment);

    Comment get(Long id);

    List<Comment> getComments();

}
