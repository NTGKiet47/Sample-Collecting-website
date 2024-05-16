package com.scweb.projectservice.dto;

import com.scweb.projectservice.model.Stage;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Stage}
 */
public record StageDto(Long id, LocalDate startDate, LocalDate endDate) implements Serializable {
}