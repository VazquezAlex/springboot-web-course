package com.alejandrovazquez.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandrovazquez.curso.springboot.webapp.springboot_web.models.User;
import com.alejandrovazquez.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

  @Value("${config.username}")
  private String username;

  // @Value("${config.message}")
  // private String message;
  
  @Value("${config.listOfValues}")
  private List<String> listOfValues;
  
  @Value("${config.code}")
  private Long code;

  @Value("#{'${config.listOfValues}'.split(',')}")
  private List<String> valueList;

  @Value("#{'${config.listOfValues}'.toUpperCase()}")
  private String valueString;

  @GetMapping("/baz/{message}")
  public ParamDto baz(@PathVariable String message) {
    ParamDto param = new ParamDto();
    param.setMessage(message);

    return param;
  }

  @GetMapping("/mix/{product}/{id}")
  public Map<String, Object> mixVariablePath(@PathVariable String product, @PathVariable Long id) {
    Map<String, Object> json = new HashMap<>();
    json.put("product", product);
    json.put("id", id);

    return json;
  }

  @PostMapping("/create")
  public User create(@RequestBody User user) {
    // Do something with the user - like save on DB.
    user.setEmail(user.getEmail().toUpperCase()); // Sample of interacting with the user.

    return user;
  }

  @GetMapping("/values")
  public Map<String, Object> getValues(@Value("${config.message}") String message) {
    Map<String, Object> json = new HashMap<>();
    json.put("username", username);
    json.put("message", message);
    json.put("listOfValues", listOfValues);
    json.put("valueList", valueList);
    json.put("valueString", valueString);
    json.put("code", code);

    return json;
  }

}
