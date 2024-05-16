package com.scweb.postservice.service;

import com.scweb.postservice.model.Post;
import com.scweb.postservice.model.UserAccount;
import com.scweb.postservice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    @Override
    public List<Post> getAllPost(String userId) {
        return postRepository.findAllByUserAccount(UserAccount.builder().userId(userId).build());
    }
}
