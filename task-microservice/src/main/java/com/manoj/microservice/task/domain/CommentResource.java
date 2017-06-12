package com.manoj.microservice.task.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by manojP on 30/5/17.
 */
public class CommentResource {

  public static final String JP_TASKID = "taskId";
  public static final String JP_COMMENT = "comment";
  public static final String JP_POSTED = "posted";

  private String taskId;
  private String comment;
  private Date posted;

  public CommentResource(){

  }

  public CommentResource(String taskId, String comment, Date posted){
    this.taskId = taskId;
    this.comment = comment;
    this.posted = posted;
  }

  @JsonProperty(JP_TASKID)
  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  @JsonProperty(JP_COMMENT)
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @JsonProperty(JP_POSTED)
  @JsonSerialize(using = CustomDateToStringSerializer.class)
  public Date getPosted() {
    return posted;
  }

  public void setPosted(Date posted) {
    this.posted = posted;
  }
}

class CustomDateToStringSerializer extends JsonSerializer<Date> {

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  @Override
  public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    String dateString = dateFormat.format(value);
    jgen.writeString(dateString);
  }
}