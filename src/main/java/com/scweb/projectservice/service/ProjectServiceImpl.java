package com.scweb.projectservice.service;

import com.scweb.projectservice.dto.ProjectOnly;
import com.scweb.projectservice.model.UserAccount;
import com.scweb.projectservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectOnly> getAllProjects(UserAccount userAccount) {
        return projectRepository.findProjectsByUserAccount(userAccount);
    }
}
