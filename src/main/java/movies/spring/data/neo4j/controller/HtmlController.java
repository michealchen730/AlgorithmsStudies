package movies.spring.data.neo4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/demo")
    public String demo() {
        return "/index.html";
    }

    @GetMapping("/homepage")
    public String homepage() {
        return "/html/homepage.html";
    }

    @GetMapping("/newforce")
    public String force() {
        return "/html/newforce.html";
    }

}
