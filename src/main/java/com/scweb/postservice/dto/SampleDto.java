package com.scweb.postservice.dto;

import com.scweb.postservice.model.Sample;
import com.scweb.postservice.model.SampleField;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Sample}
 */
public record SampleDto(Long id, String imagePath) implements Serializable {
}