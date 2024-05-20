package com.scweb.postservice.controller;

import com.scweb.postservice.model.Post;
import com.scweb.postservice.model.Sample;
import com.scweb.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(List<Sample> sampleList, String content){
        Post newPost = new Post();
        newPost.setContent(content);
        newPost.setSampleList(sampleList);
        postService.createPost(newPost);
        return (postService.isPostExist(newPost))
                ? ResponseEntity.status(409).build()
                : ResponseEntity.ok(newPost);
    }

//    @GetMapping
//    public ResponseEntity<Post>
}
