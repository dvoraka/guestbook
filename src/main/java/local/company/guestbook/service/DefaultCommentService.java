package local.company.guestbook.service;

import local.company.guestbook.dao.CommentDAO;
import local.company.guestbook.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dvoraka on 5/6/14.
 */
@Service
@Transactional
public class DefaultCommentService implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List<Comment> getComments() {

        return commentDAO.getComments();
    }

    @Override
    public long count() {

        return commentDAO.count();
    }
}
