package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // method 실행
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!?!");
        return "hello";
        // templates/hello.html을 찾는다
    }
}
