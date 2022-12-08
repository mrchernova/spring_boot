package org.example.SpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Objects;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
//1            Model model
            Map<String, Object> model
    ) {
//1        model.addAttribute("name", name);
        model.put("name", name);
        return "greeting.html";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        model.put("some", "Obama");
        return "main";
    }

}