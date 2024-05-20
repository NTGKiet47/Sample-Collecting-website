package com.scweb.postservice.dto;

import com.scweb.postservice.model.Sample;
import com.scweb.postservice.model.SampleField;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Sample}
 */
public record SampleDto(Long id, String imagePath, List<SampleFieldDto> sampleFieldList) implements Serializable {
    /**
     * DTO for {@link SampleField}
     */
    public record SampleFieldDto(Long id, String fieldName, String fieldValue) implements Serializable {
    }
}