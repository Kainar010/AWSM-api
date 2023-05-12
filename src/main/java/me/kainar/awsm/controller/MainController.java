package me.kainar.awsm.controller;

import jakarta.servlet.http.HttpServletResponse;
import me.kainar.awsm.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private MailService service;

    @PostMapping("")
    public String hello() throws Exception{
        service.sendEmail("kainar0215@mail.ru", "hello", "hello Kainar");
        return "{\"message\": \"Fuck you!\"}";
    }
}
