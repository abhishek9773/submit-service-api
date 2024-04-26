package com.api.submitservice.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
  private Long id;
  private String title;
  private String image;
  private Long assignedUserId;
  private List<String> tages = new ArrayList<>();

  private TaskStatus status;

  private LocalDateTime deadline;
  private LocalDateTime createdAt;
  private String description;

}
