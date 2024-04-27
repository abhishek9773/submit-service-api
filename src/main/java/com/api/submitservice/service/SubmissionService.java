package com.api.submitservice.service;

import java.util.List;

import com.api.submitservice.model.Submission;

public interface SubmissionService {

  Submission submitTask(Long taskId, String githubLink, Long userId , String jwt) throws Exception;

  Submission getTastSubmissionById(Long submissionId) throws Exception;

  List<Submission> getAllTaskSubmissions();

  List<Submission> getTaskSubmissionsByTaskId(Long taskId);

  Submission accpetDeclineSubmission(Long id, String status) throws Exception;

}
