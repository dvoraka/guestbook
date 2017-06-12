package local.company.guestbook

import local.company.guestbook.service.AuthorService
import local.company.guestbook.service.DefaultVoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Ignore
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration
@Ignore
class TestSpec extends Specification {

    @Autowired
    AuthorService authorService

    @Autowired
    DefaultVoteService voteService


    def "test"() {
        expect:
            println voteService.findAll()
    }

    def "generate authors"() {
        given:
            long count = 1_000

        expect:
            count.times {
                authorService.addRandomAuthor()
            }
    }
}
