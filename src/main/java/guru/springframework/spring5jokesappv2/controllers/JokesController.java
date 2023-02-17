package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    private final JokeService jokeService;

    // this annotation is not mandatory, but I prefer it for readability
    @Autowired
    // this dependency injection is possible since this class is a Spring managed bean (@Controller)
    public JokesController(JokeService jokeService) {
        // use interfaces instead of concrete classes, as it promotes:
        // abstraction, loose coupling, testability
        this.jokeService = jokeService;
    }

    @RequestMapping("/")
    public String showJoke(Model model) {

        // let's enhance the model with a joke before returning it
        model.addAttribute("joke", jokeService.getJoke());

        // looks for the index template inside the templates directory
        return "index";
    }
}
