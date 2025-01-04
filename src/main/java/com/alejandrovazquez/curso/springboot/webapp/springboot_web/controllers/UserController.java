package com.alejandrovazquez.curso.springboot.webapp.springboot_web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alejandrovazquez.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

  @GetMapping("/details")
  public String details(Model model) {
    User user = new User("Alejandro", "Vazquez");
    user.setEmail("alejandro@email.com");
    model.addAttribute("title", "Hola Mundo Spring Boot");
    model.addAttribute("user", user);

    return "details";
  }

}
