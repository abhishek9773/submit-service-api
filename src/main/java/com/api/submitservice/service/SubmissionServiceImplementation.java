package com.api.submitservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.submitservice.model.Submission;

@Service
public class SubmissionServiceImplementation implements SubmissionService {

  @Override
  public Submission submitTask(Long tastId, String githubLink, Long userId) throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'submitTask'");
  }

  @Override
  public Submission getTastSubmissionById(Long submissionId) throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getTastSubmissionById'");
  }

  @Override
  public List<Submission> getAllTaskSubmissions() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllTaskSubmissions'");
  }

  @Override
  public List<Submission> getTaskSubmissionsByTaskId(Long taskId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getTaskSubmissionsByTaskId'");
  }

  @Override
  public Submission accpetDeclineSubmission(Long id, String status) throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'accpetDeclineSubmission'");
  }

}
