package com.manoj.microservice.task.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

/**
 * Created by synerzip on 30/5/17.
 */
@Configuration
public class CommentServiceConfig {

  @Bean
  @LoadBalanced
  public OAuth2RestTemplate restTemplate(OAuth2ProtectedResourceDetails resource,
      OAuth2ClientContext context){

    return new OAuth2RestTemplate(resource, context);
  }
}
