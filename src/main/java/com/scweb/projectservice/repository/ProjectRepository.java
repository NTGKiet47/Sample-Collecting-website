package com.scweb.projectservice.repository;

import com.scweb.projectservice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByProjectName(String ownerId);
}
