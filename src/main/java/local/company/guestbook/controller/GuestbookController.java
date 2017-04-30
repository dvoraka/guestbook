package local.company.guestbook.controller;

import local.company.guestbook.model.Author;
import local.company.guestbook.model.Comment;
import local.company.guestbook.service.AuthorService;
import local.company.guestbook.service.CommentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

/**
 * Guestbook controller.
 */
@Controller
public class GuestbookController {

    private final CommentService commentService;
    private final AuthorService authorService;

    private static final Logger log = LogManager.getLogger(GuestbookController.class);


    @Autowired
    public GuestbookController(CommentService commentService, AuthorService authorService) {
        this.commentService = commentService;
        this.authorService = authorService;
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

        List<Author> foundAuthors = authorService.getAuthorsByName("mary");
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
        log.debug("Saved: {}", randomAuthor);

        return randomAuthor;
    }

    private Comment saveRandomComment(Author author) {
        Comment randomComment = commentService.addRandomComment(author);
        log.debug("Saved: {}", randomComment);

        return randomComment;
    }

    @GetMapping("/delete-user/{userId}")
    public String delUser(@PathVariable("userId") long id) {
        authorService.deleteAuthor(id);

        return "redirect:/";
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
}
