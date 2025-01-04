package com.alejandrovazquez.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

  @GetMapping("/list")
  public String list(ModelMap model) {
    // List<User> users = Arrays.asList(
    //   new User("John", "Doe"),
    //   new User("Alejandro", "Vazquez", "alejandro@email.com"),
    //   new User("Lalo", "Perez")
    // );
    // model.addAttribute("users", users); <-- removed this to add through @ModelAttribute.

    model.addAttribute("title", "Users List");

    return "list";
  }

  // This is used to inject the users into the view with this Annotation, this applies to all controller methods.
  @ModelAttribute("users")
  public List<User> usersModel() {
    List<User> users = Arrays.asList(
      new User("John", "Doe"),
      new User("Alejandro", "Vazquez", "alejandro@email.com"),
      new User("Lalo", "Perez")
    );

    return users;
  }
  

}
