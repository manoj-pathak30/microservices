package com.manoj.microservice.task.service;

import com.manoj.microservice.task.domain.CommentCollectionResource;
import com.manoj.microservice.task.domain.CommentResource;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

/**
 * Created by manojP on 30/5/17.
 */
@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  private OAuth2RestTemplate restTemplate;


  @Override
  @HystrixCommand(fallbackMethod = "getFallbackCommentsForTask", commandProperties = {
      @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
      @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
      @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000") })
  public CommentCollectionResource getCommentForTask(String taskId){

    String token = ((OAuth2AuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getTokenValue();

    restTemplate.getOAuth2ClientContext().setAccessToken(new DefaultOAuth2AccessToken(token));

    return restTemplate.getForObject(
        String.format("http://COMMENT-MICROSERVICE/comments-service/comments/%s", taskId),
        CommentCollectionResource.class);
  }

  @SuppressWarnings("unused")
  private CommentCollectionResource getFallbackCommentsForTask(String taskId) {
    // Get the default comments
    CommentCollectionResource comments = new CommentCollectionResource();
    comments.addComment(
        new CommentResource(taskId, "default comment", new Date(System.currentTimeMillis())));

    return comments;
  }

}
