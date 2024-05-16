package com.scweb.projectservice.service;

import com.scweb.projectservice.dto.ProjectDto;
import com.scweb.projectservice.dto.SampleDto;
import com.scweb.projectservice.dto.SampleFieldDto;
import com.scweb.projectservice.dto.StageDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> getAllProjects(String userId);

    List<StageDto> getAllStages(Long projectId);

    List<SampleDto> getAllSamples(Long stageId);

    List<SampleFieldDto> getAllFields(Long sampleId);
}
