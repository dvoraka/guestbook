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
import org.springframework.security.crypto.password.PasswordEncoder;
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

/**
 * Guestbook controller.
 */
@Controller
public class GuestbookController {

    private final CommentService commentService;
    private final AuthorService authorService;
    private final DefaultVoteService voteService;
    private final PasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(GuestbookController.class);


    @Autowired
    public GuestbookController(
            CommentService commentService,
            AuthorService authorService,
            DefaultVoteService voteService,
            PasswordEncoder passwordEncoder
    ) {
        this.commentService = commentService;
        this.authorService = authorService;
        this.voteService = voteService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Index page.
     */
    @GetMapping("/")
    public String index(Model model, Principal principal) {

        String username = "";
        if (principal != null) {
            username = principal.getName();
        }
        model.addAttribute("user", username);

        long count = authorService.count();
        model.addAttribute("counter", count);

        long commentCount = commentService.count();
        model.addAttribute("commentCounter", commentCount);

        List<Comment> comments = commentService.getComments();
        model.addAttribute("comments", comments);

        List<Author> authors = authorService.listAuthors();
        model.addAttribute("users", authors);

        List<Vote> votes = voteService.findAll();
        model.addAttribute("votes", votes);

        List<Author> foundAuthors = Collections.emptyList();
        model.addAttribute("foundUsers", foundAuthors);

        return "index";
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
            author.setPassword(passwordEncoder
                    .encode(author.getPassword()));

            authorService.addAuthor(author);

            return "redirect:/";
        }
    }

    @ExceptionHandler(DataAccessException.class)
    public String databaseError(DataAccessException ex) {
        log.warn("Database error: ", ex);

        return "dbError";
    }
}
