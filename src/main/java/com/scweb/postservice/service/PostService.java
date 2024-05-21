package com.scweb.postservice.service;


import com.scweb.postservice.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Boolean isPostExist(Post post);

    Post createPost(List<Long> sampleIds, String content);

    Optional<Post> getPost(Long postId);
}
