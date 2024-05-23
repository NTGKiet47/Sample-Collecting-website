package com.scweb.postservice.service;

import com.scweb.postservice.dto.SampleDto;
import com.scweb.postservice.feign.ProjectFeign;
import com.scweb.postservice.model.Post;
import com.scweb.postservice.model.Sample;
import com.scweb.postservice.model.SampleField;
import com.scweb.postservice.model.SampleId;
import com.scweb.postservice.repository.PostRepository;
import com.scweb.postservice.repository.SampleFieldRepository;
import com.scweb.postservice.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final ProjectFeign projectFeign;

    private final PostRepository postRepository;

    private final SampleRepository sampleRepository;

    private final SampleFieldRepository sampleFieldRepository;

    @Override
//    public Post createPost(List<Long> sampleIds, String content) {
//        List<SampleDto> sampleDtoList = projectFeign.getSampleList(sampleIds);
//
//        Post post = Post.builder().content(content).build();
//        List<Sample> sampleList = new ArrayList<>();
//        sampleRepository.saveAll(sampleDtoList.stream()
//                .map(s -> {
//                            Sample sample = new Sample();
//                            sample.setId(s.id());
//                            sample.setImagePath(s.imagePath());
//                            sample.setPost(post);
//
//                            sampleList.add(sample);
//                            post.setSampleList(sampleList);
//                            return sample;
//                        }
//                ).toList()
//        );
//        sampleList.forEach(sample -> {
//            projectFeign.getAllFields(sample.getId()).forEach(field -> {
//                SampleField sampleField = new SampleField();
//                sampleField.setId(field.id());
//                sampleField.setFieldName(field.fieldName());
//                sampleField.setFieldValue(field.fieldValue());
//
//                sampleField.setSample(sample);
//                sampleFieldRepository.save(sampleField);
//            });
//        });
//        return post;
//    }
    public Post createPost(List<Long> sampleIds, String content) {
        Post post = Post.builder()
                .content(content)
                .build();

        Set<Sample> samples = projectFeign.getSampleList(sampleIds).stream().map(sampleDto -> {
            Sample sample = Sample.builder()
                    .imagePath(sampleDto.imagePath())
//                    .post(post)
                    .build();
            Set<SampleField> fields = sampleDto.sampleFieldList().stream().map(field ->
                    SampleField.builder()
                            .fieldName(field.fieldName())
                            .fieldValue(field.fieldValue())
//                            .sample(sample)
                            .build()).collect(Collectors.toSet());
            sample.setSampleFields(fields);
            return sample;
        }).collect(Collectors.toSet());

        post.setSamples(samples);

        return postRepository.save(post);
    }

    @Override
    public Optional<Post> getPost(Long postId) {
        return postRepository.findById(postId);
    }

    @Override
    public Boolean deletePost(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) return false;
        postRepository.delete(post.get());
        return true;
    }

    @Override
    public Boolean editPostContent(Long postId, String content) {
        Optional<Post> oldPost = postRepository.findById(postId);
        oldPost.ifPresent(post -> {
            post.setContent(content);
            postRepository.save(post);
        });
        return false;
    }
}
