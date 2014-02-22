package local.company.guestbook;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Class for guestbook controller.
 *
 * @author dvoraka
 */
@Controller
public class GuestbookController {

    @Autowired
    private SimpleUserService userService;

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

        List<User> users = userService.getUsers();
        model.addAttribute("users", users);

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

        return "redirect:/";
    }
}
