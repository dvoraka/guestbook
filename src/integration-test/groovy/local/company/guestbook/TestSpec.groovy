package local.company.guestbook

import local.company.guestbook.model.Author
import local.company.guestbook.model.Comment
import local.company.guestbook.model.Vote
import local.company.guestbook.service.AuthorService
import local.company.guestbook.service.CommentService
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
    CommentService commentService
    @Autowired
    DefaultVoteService voteService


    def "test"() {
        expect:
            println voteService.findAll()
    }

    def "generate data"() {
        given:
            long count = 100_000

        expect:
            count.times {
                Author author = authorService.genRandomAuthor()
                Comment comment = commentService.genRandomComment(author)

                Vote vote1 = new Vote()
                vote1.setAuthor(author)
                vote1.setComment(comment)

                Vote vote2 = new Vote()
                vote2.setAuthor(author)
                vote2.setComment(comment)

                comment.setVotes(Arrays.asList(vote1, vote2))
                author.setComments(Arrays.asList(comment))

                authorService.addAuthor(author)
                commentService.addComment(comment)
                voteService.save(vote1)
                voteService.save(vote2)
            }
    }
}
