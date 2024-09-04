package io.infinitydown.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for handling requests to the home page.
 */
@Controller
@RequestMapping("/index")
public class HomeController {

    /**
     * Displays the home page.
     *
     * @return the view name for the home page
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public String home() {
        return "index";
    }
}
