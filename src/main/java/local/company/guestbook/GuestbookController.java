package local.company.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class GuestbookController {

    @Autowired
    private SimpleUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        long count = userService.count();
        model.addAttribute("counter", count);

        return "index";
    }
}
