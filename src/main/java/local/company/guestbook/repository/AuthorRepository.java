package local.company.guestbook.repository;

import local.company.guestbook.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for authors.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    //    Stream<Author> findByUsername(String username);
    Author findByUsername(String username);
}
