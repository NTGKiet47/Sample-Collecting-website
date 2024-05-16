package com.scweb.postservice.controller;

import com.scweb.postservice.model.Post;
import com.scweb.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    @GetMapping
    public ResponseEntity<List<Post>> getAllPost(String userId){
        return ResponseEntity.ok(postService.getAllPost(userId));
    }
}
