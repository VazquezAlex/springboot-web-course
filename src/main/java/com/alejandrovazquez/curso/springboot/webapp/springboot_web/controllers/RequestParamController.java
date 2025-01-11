package com.alejandrovazquez.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alejandrovazquez.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.alejandrovazquez.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

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

  @GetMapping("/bar")
  public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {
    ParamMixDto param = new ParamMixDto();
    param.setMessage(text);
    param.setCode(code);

    return param;
  }

  @GetMapping("/request")
  public ParamMixDto request(HttpServletRequest request) {
    Integer code = 0;
    try {
      code = Integer.parseInt(request.getParameter("code"));
    } catch (NumberFormatException e) {}

    ParamMixDto params = new ParamMixDto(request.getParameter("message"), code);

    return params;
  }

}
