package com.scweb.projectservice.service;

import com.scweb.projectservice.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects(String userId);
}
