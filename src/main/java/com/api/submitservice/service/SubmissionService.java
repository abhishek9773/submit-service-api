package com.api.submitservice.service;

import java.util.List;

import com.api.submitservice.model.Submission;

public interface SubmissionService {

  Submission submitTask(Long tastId, String githubLink, Long userId) throws Exception;

  Submission getTastSubmissionById(Long submissionId) throws Exception;

  List<Submission> getAllTaskSubmissions();

  List<Submission> getTaskSubmissionsByTaskId(Long taskId);

  Submission accpetDeclineSubmission(Long id, String status) throws Exception;

}
