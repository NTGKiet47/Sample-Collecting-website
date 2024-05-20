package com.scweb.postservice.service;

import com.scweb.postservice.feign.ProjectFeign;
import com.scweb.postservice.model.Post;
import com.scweb.postservice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final ProjectFeign projectFeign;

    private final PostRepository postRepository;

    @Override
    public Boolean isPostExist(Post post) {
        return postRepository.findById(post.getId()).isPresent();
    }

    @Override
    public void createPost(Post newPost) {
        postRepository.save(newPost);
    }
}
