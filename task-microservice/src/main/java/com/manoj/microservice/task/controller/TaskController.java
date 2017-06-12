package com.manoj.microservice.task.controller;

import com.manoj.microservice.task.domain.Task;
import com.manoj.microservice.task.service.CommentService;
import com.manoj.microservice.task.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by synerzip on 25/5/17.
 */
@RestController
public class TaskController {

  @Autowired
  private TaskService taskService;

  @Autowired
  private CommentService commentService;


  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Task> getTasks() {

    return taskService.getTasks();
  }

  @RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
  public Task getTaskById(@PathVariable("taskId") String taskId) {

    Task task = taskService.getTaskByTaskId(taskId);

    task.setComments(this.commentService.getCommentForTask(taskId));

    return task;
  }

  @RequestMapping(value = "/usertask/{userName}", method = RequestMethod.GET)
  public Task getTaskByUserName(@PathVariable("userName") String userName) {

    return taskService.getTaskByUserName(userName);
  }
}
