package com.manoj.microservice.task.service;


import com.manoj.microservice.task.domain.Task;
import java.util.List;


/**
 * Created by manojP on 25/5/17.
 */
public interface TaskService {

  public List<Task> getTasks();

  public Task getTaskByTaskId(String taskId);

  public Task getTaskByUserName(String userName);
}
