package com.alejandrovazquez.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alejandrovazquez.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {

  @GetMapping("/foo")
  public ParamDto foo(
    @RequestParam(required = false, defaultValue = "No message specified", name = "mensaje") String message // if no name is specified, default is variable name.
  ) {
    ParamDto param = new ParamDto();
    param.setMessage(message);

    return param;
  }

}
