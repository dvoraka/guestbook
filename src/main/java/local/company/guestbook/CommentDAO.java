package local.company.guestbook;

import java.util.List;

public interface CommentDAO {

    long count();

    void add(Comment comment);

    Comment get(Long id);

    List<Comment> getComments();

}
