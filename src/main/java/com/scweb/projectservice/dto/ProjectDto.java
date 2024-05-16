package com.scweb.projectservice.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.scweb.projectservice.model.Project}
 */
public record ProjectDto(Long id, String projectName, String projectDesc) implements Serializable {
}