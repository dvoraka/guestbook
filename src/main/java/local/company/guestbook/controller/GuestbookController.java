package local.company.guestbook.controller;

import local.company.guestbook.model.Author;
import local.company.guestbook.model.Comment;
import local.company.guestbook.service.CommentService;
import local.company.guestbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Guestbook controller.
 */
@Controller
public class GuestbookController {

    private final CommentService commentService;
    private final UserService userService;


    @Autowired
    public GuestbookController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    /**
     * Index page.
     */
    @GetMapping(value = "/")
    public String index(Model model) {

        long count = userService.count();
        model.addAttribute("counter", count);

        long commentCount = commentService.count();
        model.addAttribute("commentCounter", commentCount);

        List<Comment> comments = commentService.getComments();
        model.addAttribute("comments", comments);

        List<Author> authors = userService.getUsers();
        model.addAttribute("users", authors);

        List<Author> foundAuthors = userService.getUsersByName("mary");
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
    @GetMapping(value = "/add-rand-user/")
    public String addRandomUser() {
        userService.addRandomUser();

        return "redirect:/";
    }

    @GetMapping(value = "/delete-user/{userId}")
    public String delUser(@PathVariable("userId") long id) {
        userService.deleteUser(id);

        return "redirect:/";
    }

    @GetMapping(value = "/reg/")
    public String registerForm(Model model) {
        model.addAttribute("user", new Author());

        return "register";
    }

    @PostMapping(value = "/reg/")
    public String registerSubmit(
            @Valid @ModelAttribute("user") Author author,
            BindingResult result
    ) {
        if (result.hasErrors()) {

            return "register";
        } else {
            author.setCreated(new Date());
            userService.addUser(author);

            return "redirect:/";
        }
    }
}
