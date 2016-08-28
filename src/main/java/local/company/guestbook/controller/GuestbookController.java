package local.company.guestbook.controller;

import local.company.guestbook.model.Comment;
import local.company.guestbook.model.User;
import local.company.guestbook.service.CommentService;
import local.company.guestbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Class for guestbook controller.
 *
 * @author dvoraka
 */
@Controller
public class GuestbookController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    /**
     * Prepares index page.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        long count = userService.count();
        model.addAttribute("counter", count);

        long commentCount = commentService.count();
        model.addAttribute("commentCounter", commentCount);

        List<Comment> comments = commentService.getComments();
        model.addAttribute("comments", comments);

        List<User> users = userService.getUsers();
        model.addAttribute("users", users);

        List<User> foundUsers = userService.getUsersByName("mary");
        model.addAttribute("foundUsers", foundUsers);

        return "index";
    }

    /**
     * Adds random user to DB and redirects to /.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add-rand-user/", method = RequestMethod.GET)
    public String addRandUser(Model model) {
        userService.addRandomUser();

        return "redirect:/";
    }

    @RequestMapping(value = "/delete-user/{userId}", method = RequestMethod.GET)
    public String delUser(@PathVariable("userId") long id, Model model) {
        userService.deleteUser(id);

        return "redirect:/";
    }

    @RequestMapping(value = "/reg/", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @RequestMapping(value = "/reg/", method = RequestMethod.POST)
    public String registerSubmit(@Valid @ModelAttribute("user") User user, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {

            return "register";
        } else {
            user.setCreated(new Date());
            userService.addUser(user);

            return "redirect:/";
        }
    }
}
