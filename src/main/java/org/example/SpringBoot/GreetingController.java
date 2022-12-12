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

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = mr.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        mr.save(message);

        Iterable<Message> messages = mr.findAll();
        model.put("messages", messages);

        return "main";
    }
//    @PostMapping("filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model){
//        Iterable<Message> messages;
//    }



}