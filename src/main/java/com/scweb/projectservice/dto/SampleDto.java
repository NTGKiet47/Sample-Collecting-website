package com.scweb.projectservice.dto;

import com.scweb.projectservice.model.Sample;

import java.io.Serializable;

/**
 * DTO for {@link com.scweb.projectservice.model.Sample}
 */
public record SampleDto(Long id, String imagePath) implements Serializable {
}