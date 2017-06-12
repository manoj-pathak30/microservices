package com.manoj.microservice.comment.domain;

import java.util.Date;

/**
 * Created by manojP on 25/5/17.
 */
public class Comment {

  private String taskId;
  private String comment;
  private Date posted;

  public Comment() {
  }

  public Comment(String taskId, String comment, Date posted) {
    this.taskId = taskId;
    this.comment = comment;
    this.posted = posted;
  }


  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Date getPosted() {
    return posted;
  }

  public void setPosted(Date posted) {
    this.posted = posted;
  }

  @Override
  public String toString() {
    return this.taskId+" "+this.comment+" "+this.posted;
  }

  @Override
  public int hashCode() {
    return 17*Integer.parseInt(taskId)*comment.length();
  }
}
