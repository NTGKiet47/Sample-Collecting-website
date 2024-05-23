package com.scweb.postservice.repository;

import com.scweb.postservice.model.Post;
import com.scweb.postservice.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
    List<Sample> findAllByPost(Post post);
}
