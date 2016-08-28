package local.company.guestbook.repository;

import local.company.guestbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);
}
