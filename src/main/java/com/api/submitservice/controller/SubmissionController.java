package com.api.submitservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.submitservice.model.Submission;
import com.api.submitservice.model.UserDto;
import com.api.submitservice.service.TaskService;
import com.api.submitservice.service.UserService;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
  @Autowired
  private Submission SubmissionService;
  @Autowired
  private UserService UserService;

  @Autowired
  private TaskService taskService;

  @PostMapping()
  public ResponseEntity<Submission> submitTask(@RequestParam Long task_id, @RequestParam String github_link,
      @RequestHeader("Authorization") String jwt) throws Exception {

    UserDto user = UserService.getuserProfile(jwt);
    Submission submission = SubmissionService.submitTask(task_id, github_link, user.getId(), jwt);
    return new ResponseEntity<>(submission, HttpStatus.CREATED);

  }

  @GetMapping("/{id}")
  public ResponseEntity<Submission> getSubmissionById(@PathVariable Long id,
      @RequestHeader("Authorization") String jwt) throws Exception {

    UserDto user = UserService.getuserProfile(jwt);
    Submission submission = SubmissionService.getTaskSubmissionById(id);
    return new ResponseEntity<>(submission, HttpStatus.CREATED);

  }

  @GetMapping()
  public ResponseEntity<List<Submission>> getAllSubmission(@PathVariable Long id,
      @RequestHeader("Authorization") String jwt) throws Exception {

    UserDto user = UserService.getuserProfile(jwt);
    List<Submission> submission = SubmissionService.getAllTaskSubmissions();
    return new ResponseEntity<>(submission, HttpStatus.CREATED);

  }

  @GetMapping("/task/{taskId}")
  public ResponseEntity<List<Submission>> getAllSubmissions(@PathVariable Long taskId,
      @RequestHeader("Authorization") String jwt) throws Exception {

    UserDto user = UserService.getuserProfile(jwt);
    List<Submission> submission = SubmissionService.getTaskSubmissionByTaskId(taskId);
    return new ResponseEntity<>(submission, HttpStatus.CREATED);

  }

  @PutMapping("/{id}")
  public ResponseEntity <Submission> acceptOrDeclineSubmission(@PathVariable Long id,
      @RequestParam("status") String status,
      @RequestHeader("Authorization") String jwt) throws Exception {

    UserDto user = UserService.getuserProfile(jwt);
    Submission submission = SubmissionService.acceptOrDeclineSubmission(id, status);
    return new ResponseEntity<>(submission, HttpStatus.CREATED);

  }

}
