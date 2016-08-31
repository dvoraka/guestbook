package local.company.guestbook.service;

import local.company.guestbook.model.Comment;
import local.company.guestbook.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Default comment service implementation.
 */
@Service
@Transactional
public class DefaultCommentService implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public long count() {
        return commentRepository.count();
    }
}
