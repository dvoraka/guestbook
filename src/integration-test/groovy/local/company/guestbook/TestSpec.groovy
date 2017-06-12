package local.company.guestbook

import local.company.guestbook.service.DefaultVoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration
class TestSpec extends Specification {

    @Autowired
    DefaultVoteService voteService


    def "test"() {
        expect:
            println voteService.findAll()
    }
}
