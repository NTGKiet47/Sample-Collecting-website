package com.scweb.projectservice.controller;

import com.scweb.projectservice.dto.*;
import com.scweb.projectservice.model.Sample;
import com.scweb.projectservice.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/project")
@RequiredArgsConstructor
@Slf4j
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects(@RequestParam(name = "userId") String userId) {
        List<ProjectDto> projectList = projectService.getAllProjects(userId);
        return ResponseEntity.ok(projectList);
    }

    @GetMapping("/stage")
    public ResponseEntity<List<StageDto>> getAllStages(@RequestParam(name = "projectId") Long projectId) {
        return ResponseEntity.ok(projectService.getAllStages(projectId));
    }

    @GetMapping("/stage/sample")
    public ResponseEntity<List<SampleDto>> getAllSamples(@RequestParam(name = "stageId") Long stageId) {
        return ResponseEntity.ok(projectService.getAllSamples(stageId));
    }

    //    @GetMapping("/stage/sample/getSampleById")
//    public ResponseEntity<Optional<SampleDto>> getSampleById(@RequestParam(name = "sampleId") Long sampleId) {
//        return ResponseEntity.ok(projectService.getSampleById(sampleId));
//    }
    @GetMapping("/stage/sample/getSampleById")
    public ResponseEntity<Optional<Sample>> getSampleById(@RequestParam(name = "sampleId") Long sampleId) {
        return ResponseEntity.ok(projectService.getSampleById(sampleId));
    }

    @GetMapping("/stage/sample/getSampleList")
    public ResponseEntity<List<Sample>> getSampleList(@RequestParam List<Long> sampleIdList) {
        return ResponseEntity.ok(projectService.getSampleList(sampleIdList));
    }

    @PostMapping
    public ResponseEntity<List<Integer>> syncProjects(@RequestParam(name = "userEmail") String userEmail) {
        return null;
    }


}
