package local.company.guestbook.controller;

import local.company.guestbook.model.Author;
import local.company.guestbook.model.Comment;
import local.company.guestbook.service.AuthorService;
import local.company.guestbook.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.time.Instant;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final AuthorService authorService;

    private static final Logger log = LoggerFactory.getLogger(CommentController.class);


    @Autowired
    public CommentController(CommentService commentService, AuthorService authorService) {
        this.commentService = commentService;
        this.authorService = authorService;
    }

    @GetMapping
    public String commentForm(Model model) {
        model.addAttribute("comment", new Comment());

        return "comment";
    }

    @PostMapping
    public String commentSubmit(
            @Valid @ModelAttribute("comment") Comment comment,
            BindingResult result,
            Principal principal
    ) {
        if (principal != null) {
            Author author = authorService.findAuthor(principal.getName())
                    .orElse(authorService.addAuthor(principal.getName()));

            comment.setAuthor(author);
            comment.setCreated(Instant.now());

            commentService.addComment(comment);
        }

        return "redirect:/";
    }

    @GetMapping("/comments")
    public String comments(Model model) {
        model.addAttribute("comments", commentService.getComments());

        return "comments";
    }
}
