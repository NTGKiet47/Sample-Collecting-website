package com.scweb.postservice.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.scweb.postservice.model.SampleField}
 */
public record SampleFieldDto(Long id, String fieldName, String fieldValue) implements Serializable {
}