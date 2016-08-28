package local.company.guestbook.dao;

import local.company.guestbook.model.Comment;

import java.util.List;

public interface CommentDAO {

    long count();

    void add(Comment comment);

    Comment get(Long id);

    List<Comment> getComments();
}
