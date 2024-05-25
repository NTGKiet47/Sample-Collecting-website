package com.scweb.postservice.service;

import com.scweb.postservice.feign.ProjectFeign;
import com.scweb.postservice.model.Post;
import com.scweb.postservice.model.Sample;
import com.scweb.postservice.model.SampleField;
import com.scweb.postservice.repository.PostRepository;
import com.scweb.postservice.repository.SampleFieldRepository;
import com.scweb.postservice.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final ProjectFeign projectFeign;

    private final PostRepository postRepository;

    private final SampleRepository sampleRepository;

    private final SampleFieldRepository sampleFieldRepository;

    private Post isPostExists(Long postId){
        Optional<Post> postOptional = postRepository.findById(postId);
        return postOptional.orElse(null);
    }

    @Override
    public Post createPost(List<Long> sampleIds, String content) {
        Post post = Post.builder().content(content).samples(new LinkedHashSet<>()).build();

        Set<Sample> samples = projectFeign.getSampleList(sampleIds).stream().map(
                sampleDto -> {
                    Optional<Sample> sampleOptional = sampleRepository.findById(sampleDto.id());
                    Sample sample = new Sample();

                    if(sampleOptional.isEmpty()){
                        sample.setId(sampleDto.id());
                        sample.setImagePath(sampleDto.imagePath());

                        Sample finalSample = sample;
                        Set<SampleField> sampleFields = sampleDto.sampleFieldList().stream().map(
                                field ->
                                        SampleField.builder()
                                                .fieldName(field.fieldName())
                                                .fieldValue(field.fieldValue())
                                                .sample(finalSample)
                                                .build()
                        ).collect(Collectors.toSet());

                        sample.setSampleFields(sampleFields);
                    }else{
                        sample = sampleOptional.get();
                    }
                    return sample;
                }
        ).collect(Collectors.toSet());

        post.assignSamples(samples);
        postRepository.save(post);
        return post;
    }

    @Override
    public Optional<Post> getPost(Long postId) {
        return postRepository.findById(postId);
    }

    @Override
    public Boolean deletePost(Long postId) {
        Post post = isPostExists(postId);
        if(post == null) return false;

        Set<Sample> samples = new HashSet<>(post.getSamples());
        post.getSamples().clear();
        postRepository.delete(post);

        // check if a sample is still associated to any remaining posts
        for (Sample sample : samples) {
            if (sample.getPosts().isEmpty()) {
                sampleRepository.delete(sample);
            }
        }

        return true;
    }

    @Override
    public Boolean editPostContent(Long postId, String content) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) return false;

        Post updatedPost = post.get();
        updatedPost.setContent(content);
        postRepository.save(updatedPost);

        return true;
    }
}
