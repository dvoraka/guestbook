package local.company.guestbook;

import java.util.List;

/**
 * Service layer for CommentDAO
 * <p/>
 * Created by dvoraka on 5/6/14.
 */
public interface CommentService {

    List<Comment> getComments();

}
