package com.manoj.microservice.comment.service;

import org.springframework.stereotype.Service;

/**
 * Created by manojP on 25/5/17.
 */
@Service
public class CommentServiceImpl implements CommentService {

 /* List<Task> taskList = Arrays.asList(
      new Task("1", "Code Task Service", true, "manoj"),
      new Task("2", "Test Task Service", true, "manoj"),
      new Task("3", "Design Task Service", true, "ayansh"),
      new Task("4", "Code Task Service", true, "ayansh"),
      new Task("5", "Code Task Service", true, "manoj")
  );


  @Override
  public List<Task> getTasks() {
    return taskList;
  }

  @Override
  public Task getTaskByTaskId(String taskId) {
    return taskList.stream().filter(task -> task.getTaskId().equals(taskId))
        .findAny().get();
  }

  @Override
  public Task getTaskByUserName(String userName) {
    return taskList.stream().filter(task -> task.getUserName().equals(userName))
        .findAny().get();
  }*/
}
