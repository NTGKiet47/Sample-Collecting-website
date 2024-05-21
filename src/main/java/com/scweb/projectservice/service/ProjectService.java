package com.scweb.projectservice.service;

import com.scweb.projectservice.dto.*;
import com.scweb.projectservice.model.Sample;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<ProjectDto> getAllProjects(String userId);

    List<StageDto> getAllStages(Long projectId);

    List<SampleDto> getAllSamples(Long stageId);

    List<SampleFieldDto> getAllFields(Long sampleId);

//    Optional<Sample> getSampleById(Long sampleId);
    Optional<SampleDto> getSampleById(Long sampleId);

    List<SampleDto> getSampleList(List<Long> sampleIdList);
}

