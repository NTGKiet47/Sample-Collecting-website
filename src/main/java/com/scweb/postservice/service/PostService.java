package com.scweb.postservice.service;

import com.scweb.postservice.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPost(String userId);
}
