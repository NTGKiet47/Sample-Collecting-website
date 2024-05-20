package com.scweb.postservice.service;


import com.scweb.postservice.model.Post;

public interface PostService {

    Boolean isPostExist(Post post);

    void createPost(Post newPost);
}
