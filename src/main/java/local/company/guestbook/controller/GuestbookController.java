package local.company.guestbook.controller;

import local.company.guestbook.model.Author;
import local.company.guestbook.model.Comment;
import local.company.guestbook.model.Vote;
import local.company.guestbook.service.AuthorService;
import local.company.guestbook.service.CommentService;
import local.company.guestbook.service.DefaultVoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Guestbook controller.
 */
@Controller
public class GuestbookController {

    private final CommentService commentService;
    private final AuthorService authorService;
    private final DefaultVoteService voteService;

    private static final Logger log = LoggerFactory.getLogger(GuestbookController.class);


    @Autowired
    public GuestbookController(
            CommentService commentService,
            AuthorService authorService,
            DefaultVoteService voteService
    ) {
        this.commentService = commentService;
        this.authorService = authorService;
        this.voteService = voteService;
    }

    /**
     * Index page.
     */
    @GetMapping("/")
    public String index(Model model) {

        long count = authorService.count();
        model.addAttribute("counter", count);

        long commentCount = commentService.count();
        model.addAttribute("commentCounter", commentCount);

        List<Comment> comments = commentService.getComments();
        model.addAttribute("comments", comments);

        List<Author> authors = authorService.getAuthors();
        model.addAttribute("users", authors);

        List<Vote> votes = voteService.findAll();
        model.addAttribute("votes", votes);

        List<Author> foundAuthors = Collections.emptyList();
        model.addAttribute("foundUsers", foundAuthors);

        return "index";
    }

    @GetMapping("/comments")
    public String comments(Model model) {
        model.addAttribute("comments", commentService.getComments());

        return "comments";
    }

    /**
     * Adds a random user to the DB and redirects to /.
     */
    @GetMapping("/add-rand-user/")
    public String addRandomUser() {
        saveRandomAuthor();

        return "redirect:/";
    }

    @GetMapping("/add-rand-comment/")
    public String addRandomComment() {
        Author randomAuthor = saveRandomAuthor();
        saveRandomComment(randomAuthor);

        return "redirect:/";
    }

    private Author saveRandomAuthor() {
        Author randomAuthor = authorService.addRandomAuthor();
        log.debug("Save author: {}", randomAuthor);

        return randomAuthor;
    }

    private Comment saveRandomComment(Author author) {
        Comment randomComment = commentService.addRandomComment(author);
        log.debug("Save comment: {}", randomComment);

        return randomComment;
    }

    @GetMapping("/reg/")
    public String registerForm(Model model) {
        model.addAttribute("user", new Author());

        return "register";
    }

    @PostMapping("/reg/")
    public String registerSubmit(
            @Valid @ModelAttribute("user") Author author,
            BindingResult result
    ) {
        if (result.hasErrors()) {

            return "register";
        } else {
            author.setCreated(Instant.now());
            authorService.addAuthor(author);

            return "redirect:/";
        }
    }

    @GetMapping("/comment/")
    public String commentForm(Model model) {
        model.addAttribute("comment", new Comment());

        return "comment";
    }

    @PostMapping("/comment/")
    public String commentSubmit(
            @Valid @ModelAttribute("comment") Comment comment,
            BindingResult result,
            Principal principal
    ) {
        if (principal != null) {
            Optional<Author> author = authorService.findAuthor(principal.getName());

            if (author.isPresent()) {
                comment.setAuthor(author.get());
                comment.setCreated(Instant.now());

                commentService.addComment(comment);
            }
        }

        return "redirect:/";
    }

    @ExceptionHandler(DataAccessException.class)
    public String databaseError(DataAccessException ex) {
        log.warn("Database error: ", ex);

        return "dbError";
    }
}
