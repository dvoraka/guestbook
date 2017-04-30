package local.company.guestbook.service;

import local.company.guestbook.model.Author;
import local.company.guestbook.model.Comment;

import java.util.List;

/**
 * Service layer for Comment repository.
 */
public interface CommentService {

    long count();

    List<Comment> getComments();

    Comment addRandomComment(Author author);
}
