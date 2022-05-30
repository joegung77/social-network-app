package com.joegung.socialnetworkappbackend.controller;

import com.joegung.socialnetworkappbackend.entity.CommentEntity;
import com.joegung.socialnetworkappbackend.entity.CommentPostRequestEntity;
import com.joegung.socialnetworkappbackend.entity.IdObjectEntity;
import com.joegung.socialnetworkappbackend.service.CommentService;
import com.joegung.socialnetworkappbackend.service.ResponseObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/insertcomment")
    public ResponseEntity<ResponseObjectService> insertComment(@RequestBody CommentPostRequestEntity postedComment) {
        CommentEntity inputComment = postedComment.getCommentEntity();
        IdObjectEntity inputPostId = postedComment.getPostId();
        return new ResponseEntity<ResponseObjectService>(commentService.insertComment(inputComment, inputPostId.getId()), HttpStatus.OK);
    }

    @GetMapping("/getcomments")
    public ResponseEntity<ResponseObjectService> getComments(@RequestBody IdObjectEntity inputPostId) {
        return new ResponseEntity<ResponseObjectService>(commentService.getComments(inputPostId.getId()), HttpStatus.OK);
    }
}
