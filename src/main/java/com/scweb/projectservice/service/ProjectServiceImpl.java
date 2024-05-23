package com.scweb.projectservice.service;

import com.scweb.projectservice.dto.*;
import com.scweb.projectservice.model.*;
import com.scweb.projectservice.repository.FieldRepository;
import com.scweb.projectservice.repository.ProjectRepository;
import com.scweb.projectservice.repository.SampleRepository;
import com.scweb.projectservice.repository.StageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final StageRepository stageRepository;

    private final SampleRepository sampleRepository;

    private final FieldRepository fieldRepository;

    @Override
    public List<ProjectDto> getAllProjects(String userId) {
        UserAccount userAccount = UserAccount.builder().userId(userId).build();
        return projectRepository.findByUserAccount(userAccount);
    }

    @Override
    public List<StageDto> getAllStages(Long projectId) {
        return stageRepository.findByProject(Project.builder().id(projectId).build());
    }

    @Override
    public List<SampleDto> getAllSamples(Long stageId) {
        return sampleRepository.findByStage(Stage.builder().id(stageId).build());
    }

    @Override
    public Optional<Sample> getSampleById(Long sampleId) {
        return sampleRepository.findById(sampleId);
    }

    @Override
    public List<Sample> getSampleList(List<Long> sampleIdList) {
        return sampleRepository.findAllById(sampleIdList);
    }
}
