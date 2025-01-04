package com.alejandrovazquez.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

  @GetMapping("/user")
  public Map<String, Object> details() {
    Map<String, Object> body = new HashMap<String, Object>();
    body.put("title", "Hola Mundo Spring Boot");
    body.put("name", "Alejandro");
    body.put("lastName", "Vazquez");

    return body;
  }

}
