package local.company.guestbook.repository;

import local.company.guestbook.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for authors.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByUsername(String username);
}
