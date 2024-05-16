package com.scweb.projectservice.controller;

import com.scweb.projectservice.dto.ProjectDto;
import com.scweb.projectservice.dto.SampleDto;
import com.scweb.projectservice.dto.SampleFieldDto;
import com.scweb.projectservice.dto.StageDto;
import com.scweb.projectservice.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
@RequiredArgsConstructor
@Slf4j
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects(@RequestParam(name = "userId") String userId){
        List<ProjectDto> projectList = projectService.getAllProjects(userId);
        return ResponseEntity.ok(projectList);
    }

    @GetMapping("/stage")
    public ResponseEntity<List<StageDto>> getAllStages(@RequestParam(name = "projectId") Long projectId){
        return ResponseEntity.ok(projectService.getAllStages(projectId));
    }

    @GetMapping("/stage/sample")
    public ResponseEntity<List<SampleDto>> getAllSamples(@RequestParam(name = "stageId") Long stageId){
        return ResponseEntity.ok(projectService.getAllSamples(stageId));
    }

    @GetMapping("/stage/sample/field")
    public ResponseEntity<List<SampleFieldDto>> getAllFields(@RequestParam(name = "sampleId") Long sampleId){
        return ResponseEntity.ok(projectService.getAllFields(sampleId));
    }

    @PostMapping
    public ResponseEntity<List<Integer>> syncProjects(@RequestParam(name = "userEmail") String userEmail){
        return null;
    }



}
