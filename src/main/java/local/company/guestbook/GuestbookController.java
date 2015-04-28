package local.company.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;

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

        List<Comment> comments = commentService.getComments();
        model.addAttribute("comments", comments);

        List<User> users = userService.getUsers();
        model.addAttribute("users", users);

        List<User> foundUsers = userService.getUsersByName("mary");
        model.addAttribute("foundusers", foundUsers);

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

        System.out.println(user + "" + result);

        if (result.hasErrors()) {

            return "register";

        } else {

            userService.addUser(user.getUsername());

            return "redirect:/";
        }
    }
}
