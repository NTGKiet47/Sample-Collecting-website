package com.scweb.postservice.dto;

import com.scweb.postservice.model.Post;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Post}
 */
@Builder
public record PostDto(List<Long> sampleIds, String content) implements Serializable {
}