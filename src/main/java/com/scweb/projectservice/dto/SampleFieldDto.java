package com.scweb.projectservice.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.scweb.projectservice.model.SampleField}
 */
public record SampleFieldDto(Long id, String fieldName, String fieldValue) implements Serializable {
}