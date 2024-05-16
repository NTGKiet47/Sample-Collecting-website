package com.scweb.postservice.repository;

import com.scweb.postservice.model.Post;
import com.scweb.postservice.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUserAccount(UserAccount userAccount);
}
