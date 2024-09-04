package io.infinitydown.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for handling the root URL and redirecting to the index page.
 */
@Controller
public class MainController {

    /**
     * Redirects the root URL to the index page.
     *
     * @return a redirect view name to "/index"
     */
    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }
}
