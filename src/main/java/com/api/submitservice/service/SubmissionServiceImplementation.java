package com.api.submitservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.submitservice.repository.SubmissionRepository;
import com.api.submitservice.model.Submission;
import com.api.submitservice.model.TaskDto;

@Service
public class SubmissionServiceImplementation implements SubmissionService {
  @Autowired
  private SubmissionRepository submissionRepository;
  @Autowired
  private TaskService taskService;

  @Override
  public Submission submitTask(Long taskId, String githubLink, Long userId, String jwt) throws Exception {
    TaskDto task = taskService.getTaskById(taskId, jwt);
    if (task != null) {
      Submission submission = new Submission();
      submission.setTaskId(taskId);
      submission.setUserId(userId);
      submission.setGithubLink(githubLink);
      submission.setSubmissionTime(LocalDateTime.now());
      return submissionRepository.save(submission);
    }
    throw new Exception("task not found wiht id: " + taskId);

  }

  @Override
  public Submission getTastSubmissionById(Long submissionId) throws Exception {

    return submissionRepository.findById(submissionId)
        .orElseThrow(() -> new Exception("Task submission not found with id" + submissionId));
  }

  @Override
  public List<Submission> getAllTaskSubmissions() {
    return submissionRepository.findAll();
  }

  @Override
  public List<Submission> getTaskSubmissionsByTaskId(Long taskId) {
    return submissionRepository.findByTaskId(taskId);
  }

  @Override
  public Submission accpetDeclineSubmission(Long id, String status) throws Exception {
    Submission submission = getTaskSubmissionById(id);
    submission.setSatus(status);
    if (status.equals("ACCEPT")) {
      taskService.completeTask(submission.getTaskId());
    }

    return submissionRepository.save(submission);
  }

}
