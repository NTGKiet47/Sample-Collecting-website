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

    @GetMapping
    public ResponseEntity<Optional<Post>> getPost(@RequestParam(name = "postId") Long postId){
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @PostMapping
    public ResponseEntity<Boolean> createPost(@RequestBody PostDto post) {
        Post postCreated = postService.createPost(post.sampleIds(), post.content(), post.domainIds());
        return postCreated != null
                ? ResponseEntity.ok(true)
                : ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Boolean> editPostContent(@RequestParam Long postId, @RequestBody String content){
        return ResponseEntity.ok(postService.editPostContent(postId, content));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestParam(name = "postId") Long postId){
        postService.deletePost(postId);
        return ResponseEntity.ok("Delete post successfully");
    }

}
