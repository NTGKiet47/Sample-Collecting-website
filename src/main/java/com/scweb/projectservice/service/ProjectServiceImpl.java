package com.scweb.projectservice.service;

import com.scweb.projectservice.model.Project;
import com.scweb.projectservice.model.UserAccount;
import com.scweb.projectservice.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects(UserAccount userAccount) {
        return projectRepository.findProjectsByUserAccount(userAccount);
    }
}
