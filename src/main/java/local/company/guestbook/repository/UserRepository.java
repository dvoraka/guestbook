package local.company.guestbook.repository;

import local.company.guestbook.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<Author, Long> {

    List<Author> findByUsername(String username);
}
