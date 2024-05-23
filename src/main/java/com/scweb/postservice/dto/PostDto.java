package com.scweb.postservice.dto;

import com.scweb.postservice.model.Post;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Post}
 */

//this DTO used for creating a post, need a list of ids (long format) and content (a string)
@Builder
public record PostDto(List<Long> sampleIds, String content) implements Serializable {
}