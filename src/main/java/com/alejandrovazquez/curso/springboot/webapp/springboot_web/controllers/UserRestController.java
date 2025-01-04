package com.alejandrovazquez.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandrovazquez.curso.springboot.webapp.springboot_web.models.User;

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

}
