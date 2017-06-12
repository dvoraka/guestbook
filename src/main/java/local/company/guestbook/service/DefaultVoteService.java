package local.company.guestbook.service;

import local.company.guestbook.model.Vote;
import local.company.guestbook.repository.VoteRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Default Vote service implementation
 */
@Component
public class DefaultVoteService {

    private final VoteRepository voteRepository;


    public DefaultVoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> findAll() {
        return voteRepository.findAll();
    }
}
