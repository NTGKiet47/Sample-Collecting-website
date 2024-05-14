package com.scweb.projectservice.controller;

import com.scweb.projectservice.model.Project;
import com.scweb.projectservice.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(@RequestParam(name = "userId") String userId){
        List<Project> projectList = projectService.getAllProjects(userId);
        return ResponseEntity.ok(projectList);
    }

    @PostMapping
    public ResponseEntity<List<Integer>> syncProjects(@RequestParam(name = "userEmail") String userEmail){
        return null;
    }


}
