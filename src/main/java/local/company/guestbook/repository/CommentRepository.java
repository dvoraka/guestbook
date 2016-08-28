package local.company.guestbook.repository;

import local.company.guestbook.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Comment repository.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}