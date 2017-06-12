package com.manoj.microservice.task.domain;

/**
 * Created by manojP on 25/5/17.
 */
public class Task {

  private String taskId;
  private String description;
  private boolean completed;
  private String userName;
  private CommentCollectionResource comments;


  public Task() {
  }

  public Task(String taskId, String description, boolean completed, String userName) {
    this.taskId = taskId;
    this.description = description;
    this.completed = completed;
    this.userName = userName;
  }

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public CommentCollectionResource getComments() {
    return comments;
  }

  public void setComments(CommentCollectionResource comments) {
    this.comments = comments;
  }
}
