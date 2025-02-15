package com.alejandrovazquez.curso.springboot.webapp.springboot_web.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandrovazquez.curso.springboot.webapp.springboot_web.models.User;
import com.alejandrovazquez.curso.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

  @GetMapping("/user")
  public Map<String, Object> details() {

    User user = new User("Alejandro", "Vazquez");
    Map<String, Object> body = new HashMap<String, Object>();

    body.put("title", "Hola Mundo Spring Boot");
    body.put("user", user);

    return body;
  }

  @GetMapping("/user-dto") // dto = Data Transfer Object.
  public UserDto detailsDto() {

    User user = new User("Alejandro", "Vazquez");
    UserDto userDto = new UserDto();
    userDto.setUser(user);
    userDto.setTitle("Hola Mundo Spring Boot");

    return userDto;
  }

  @GetMapping("/list")
  public List<User> list() {
    User user = new User("Alejandro", "Vazquez");
    User user2 = new User("Sofia", "Ro");
    User user3 = new User("Misu", "Nabi");

    List<User> users = Arrays.asList(user, user2, user3);
    // List<User> users = new ArrayList<User>(); <-- option with ArrayList.
    // users.add(user);
    // users.add(user2);
    // users.add(user3);

    return users;
  }

}
