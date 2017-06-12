package com.manoj.microservice.task.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by manojP on 30/5/17.
 */
@JsonDeserialize(using = CommentsCollectionDeserializer.class)
public class CommentCollectionResource {

  List<CommentResource> taskComments;


  public void addComment(CommentResource comment) {
    if (this.taskComments == null) {
      this.taskComments = new ArrayList<>();
    }
    this.taskComments.add(comment);
  }

}


class CommentsCollectionDeserializer extends JsonDeserializer {

  @Override
  public CommentCollectionResource deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    CommentCollectionResource commentArrayResource = new CommentCollectionResource();
    CommentResource commentResource = null;
    JsonNode jsonNode = jp.readValueAsTree();
    for (JsonNode childNode : jsonNode) {
      if (childNode.has(CommentResource.JP_TASKID)) {
        commentResource = new CommentResource();
        commentResource.setTaskId(childNode.get(CommentResource.JP_TASKID).asText());
        commentResource.setComment(childNode.get(CommentResource.JP_COMMENT).asText());
        commentResource.setPosted(new Date(childNode.get(CommentResource.JP_POSTED).asLong()));
        commentArrayResource.addComment(commentResource);
      }
    }
    return commentArrayResource;
  }
}