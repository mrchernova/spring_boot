package org.example.SpringBoot;

import org.example.SpringBoot.model.Message;
import org.example.SpringBoot.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepository mr;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
//1            Model model
            Map<String, Object> model
    ) {
//1        model.addAttribute("name", name);
        model.put("name", name);
        return "greeting.html";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = mr.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        mr.save(message);

        Iterable<Message> messages = mr.findAll();
        model.put("messages", messages);

        return "main";
    }


}