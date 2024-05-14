package com.scweb.projectservice.service;

import com.scweb.projectservice.model.Project;
import com.scweb.projectservice.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects(String userId) {
        return projectRepository.findByProjectName(userId);
    }
}
