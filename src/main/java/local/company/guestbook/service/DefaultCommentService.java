package local.company.guestbook.service;

import local.company.guestbook.model.Author;
import local.company.guestbook.model.Comment;
import local.company.guestbook.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

/**
 * Default comment service implementation.
 */
@Service
@Transactional
public class DefaultCommentService implements CommentService {

    private final CommentRepository commentRepository;


    @Autowired
    public DefaultCommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment addRandomComment(Author author) {
        return commentRepository.save(genRandomComment(author));
    }

    @Override
    public Comment genRandomComment(Author author) {
        Comment comment = new Comment();
        comment.setAuthor(author);

        comment.setCreated(Instant.now());
        comment.setText("RANDOMCOMMENT");

        return comment;
    }

    @Override
    public long count() {
        return commentRepository.count();
    }
}
