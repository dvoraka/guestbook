package local.company.guestbook.controller;

import local.company.guestbook.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    private static final Logger log = LoggerFactory.getLogger(AuthorController.class);


    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
}
