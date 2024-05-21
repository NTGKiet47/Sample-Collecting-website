package com.scweb.postservice.controller;

import com.scweb.postservice.model.Post;
import com.scweb.postservice.dto.PostDto;
import com.scweb.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Boolean> createPost(@RequestBody PostDto requestBody) {
        return postService.createPost(requestBody.sampleIds(), requestBody.content()) != null
                ? ResponseEntity.ok(true)
                : ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<Optional<Post>> getPost(@RequestParam(name = "postId") Long postId){
        return ResponseEntity.ok(postService.getPost(postId));
    }

}
