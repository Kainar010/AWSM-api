package me.kainar.awsm.controller;

import jakarta.servlet.http.HttpServletResponse;
import me.kainar.awsm.form.LoginForm;
import me.kainar.awsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import me.kainar.awsm.model.*;
import me.kainar.awsm.service.*;

import java.util.HashMap;

@RestController
@RequestMapping("users/")
@CrossOrigin()
@Transactional
public class UserController{

    private UserService userService;

    @PostMapping(value = "register/")
    public HashMap<String, String> register(@RequestBody LoginForm loginForm){
        String username = loginForm.getUsername();
        String authString = loginForm.getAuthString();
        User user = (User)userService.getUser(username);
        System.out.println("It is work");
        if(user == null){
            System.out.println("user is null");
        }else{
            System.out.println(user.getUserName());
            System.out.println(user.getAuthString()+" "+authString);
        }
        HashMap<String, String> map = new HashMap<>();
        if(user.getAuthString().equals(authString)){
            map.put("message", "login successful!");
            map.put("token", "fake_token");
            return map;
        }

        map.put("message", "username or password incorrect");
        return map;
    }

    @GetMapping("/register")
    public String verifyRegistration(@RequestBody String token){
        return "fuck u";
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}







