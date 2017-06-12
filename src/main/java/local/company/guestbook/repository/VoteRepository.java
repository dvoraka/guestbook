package local.company.guestbook.repository;

import local.company.guestbook.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for votes.
 */
@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
