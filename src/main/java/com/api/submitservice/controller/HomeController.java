package com.api.submitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @GetMapping("/submission")
  public ResponseEntity<String> HomeController() {
    return new ResponseEntity<>("welcom to submission service", HttpStatus.OK);
  }

}
