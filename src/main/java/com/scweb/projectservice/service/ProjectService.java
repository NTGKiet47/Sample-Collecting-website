package com.scweb.projectservice.service;

import com.scweb.projectservice.dto.ProjectOnly;
import com.scweb.projectservice.model.UserAccount;

import java.util.List;

public interface ProjectService {
    List<ProjectOnly> getAllProjects(UserAccount userAccount);
}
