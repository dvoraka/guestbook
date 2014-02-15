package local.company.guestbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dvoraka
 */
@Controller
@RequestMapping("/")
public class GuestbookController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        
        return "index";
    }
    
}
