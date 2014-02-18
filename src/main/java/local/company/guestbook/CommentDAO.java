package local.company.guestbook;

public interface CommentDAO {

    void add(Comment comment);

    Comment get(Long id);

}
