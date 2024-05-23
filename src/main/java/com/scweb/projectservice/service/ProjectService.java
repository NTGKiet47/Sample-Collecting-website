package com.scweb.projectservice.service;

import com.scweb.projectservice.dto.*;
import com.scweb.projectservice.model.Sample;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<ProjectDto> getAllProjects(String userId);

    List<StageDto> getAllStages(Long projectId);

    List<SampleDto> getAllSamples(Long stageId);

//    Optional<Sample> getSampleById(Long sampleId);
    Optional<Sample> getSampleById(Long sampleId);

    List<Sample> getSampleList(List<Long> sampleIdList);
}

