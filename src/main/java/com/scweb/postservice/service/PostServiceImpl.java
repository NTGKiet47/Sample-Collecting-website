package com.scweb.postservice.service;

import com.scweb.postservice.dto.SampleDto;
import com.scweb.postservice.feign.ProjectFeign;
import com.scweb.postservice.model.Post;
import com.scweb.postservice.model.Sample;
import com.scweb.postservice.model.SampleField;
import com.scweb.postservice.repository.SampleFieldRepository;
import com.scweb.postservice.repository.PostRepository;
import com.scweb.postservice.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final ProjectFeign projectFeign;

    private final PostRepository postRepository;

    private final SampleRepository sampleRepository;

    private final SampleFieldRepository sampleFieldRepository;

    @Override
    public Boolean isPostExist(Post post) {
        return postRepository.findById(post.getId()).isPresent();
    }

    @Override
    public Post createPost(List<Long> sampleIds, String content) {
        List<SampleDto> sampleDtoList = projectFeign.getSampleList(sampleIds);

        Post post = postRepository.save(Post.builder().content(content).build());
        List<Sample> sampleList = new ArrayList<>();
        sampleRepository.saveAll(sampleDtoList.stream()
                .map(s -> {
                            Sample sample = new Sample();
                            sample.setId(s.id());
                            sample.setImagePath(s.imagePath());
                            sample.setPost(post);

                            sampleList.add(sample);
                            post.setSampleList(sampleList);

                            return sample;
                        }
                ).toList()
        );
        sampleList.forEach(sample -> {
            projectFeign.getAllFields(sample.getId()).forEach(field -> {
                SampleField sampleField = new SampleField();
                sampleField.setId(field.id());
                sampleField.setFieldName(field.fieldName());
                sampleField.setFieldValue(field.fieldValue());

                sampleField.setSample(sample);

                sampleFieldRepository.save(sampleField);
            });
        });

        return post;
    }

    @Override
    public Optional<Post> getPost(Long postId) {
//        return postRepository.findById(postId)
//                .map(post -> PostDto.builder()
//                        .sampleIds(post.getSampleList().stream()
//                                .map(Sample::getId)
//                                .toList())
//                        .content(post.getContent()).build())
//                .orElse(null);
        return postRepository.findById(postId);
    }
}
