package local.company.guestbook.service;

import local.company.guestbook.model.Comment;

import java.util.List;

/**
 * Service layer for CommentDAO
 * <p/>
 * Created by dvoraka on 5/6/14.
 */
public interface CommentService {

    long count();

    List<Comment> getComments();
}
