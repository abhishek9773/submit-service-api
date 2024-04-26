package com.api.submitservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "USER-SERVICE", url = "http://localhost:5001")
public interface UserService {

  @GetMapping("/api/users/profile")
  public UserDto getuserProfile(@RequestHeader("Authorization") String jwt);

}
