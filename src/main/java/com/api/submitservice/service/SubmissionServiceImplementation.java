package com.api.submitservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.submitservice.repository.SubmissionRepository;
import com.api.submitservice.model.Submission;

@Service
public class SubmissionServiceImplementation implements SubmissionService {
  @Autowired
  private SubmissionRepository SubmissionRepository;

  @Override
  public Submission submitTask(Long tastId, String githubLink, Long userId) throws Exception {

    return null;
  }

  @Override
  public Submission getTastSubmissionById(Long submissionId) throws Exception {
    return null;
  }

  @Override
  public List<Submission> getAllTaskSubmissions() {
    return null;
  }

  @Override
  public List<Submission> getTaskSubmissionsByTaskId(Long taskId) {
    return null;
  }

  @Override
  public Submission accpetDeclineSubmission(Long id, String status) throws Exception {
    return null;
  }

}
