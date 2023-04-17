package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(GreetingController.GREETING)
public class GreetingController {
    public static final String GREETING = "/greeting";
    @Value("${exemple.valor}")
    String valor;

    @Autowired
    GreetingService greetingService;
    @GetMapping
    public String greetingGet(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        greetingService.addMessage(name);
        model.addAttribute("llista", greetingService.getMessages());
        model.addAttribute("name", name);
        model.addAttribute("valor",valor);

        return "greeting";
    }
    @PostMapping
    public String greetingPost(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}