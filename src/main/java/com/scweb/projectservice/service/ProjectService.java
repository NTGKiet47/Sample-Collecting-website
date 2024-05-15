package com.scweb.projectservice.service;

import com.scweb.projectservice.model.Project;
import com.scweb.projectservice.model.UserAccount;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects(UserAccount userAccount);
}
