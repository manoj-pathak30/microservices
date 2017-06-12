package com.manoj.microservice.task.service;

import com.manoj.microservice.task.domain.CommentCollectionResource;

/**
 * Created by synerzip on 30/5/17.
 */
public interface CommentService {

  public CommentCollectionResource getCommentForTask(String taskId);
}
