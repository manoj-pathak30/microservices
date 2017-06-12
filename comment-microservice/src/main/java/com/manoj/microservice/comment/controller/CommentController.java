package com.manoj.microservice.comment.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.manoj.microservice.comment.domain.Comment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by synerzip on 25/5/17.
 */
@RestController
public class CommentController {

  private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
  private List<Comment> comments;

  public CommentController() throws ParseException {
    this.comments = Arrays
        .asList(
            new Comment("1", "This is task one comment", formatter.parse("2015-04-23")),
            new Comment("2", "This is task two comment", formatter.parse("2015-05-12")),
            new Comment("3", "This is task three comment", formatter.parse("2015-04-27")),
            new Comment("4", "This is task four comment", formatter.parse("2015-01-15")),
            new Comment("5", "This is task five comment", formatter.parse("2015-03-05")));
  }

  @RequestMapping(value = "/comments/{taskId}", method = GET)
  public List getCommentsByTaskId(@PathVariable String taskId) {
    return comments.stream().filter(comment -> comment.getTaskId().equals(taskId))
        .collect(Collectors.toList());
  }

}
