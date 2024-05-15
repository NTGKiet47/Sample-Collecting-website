package com.scweb.projectservice.controller;

import com.scweb.projectservice.model.Project;
import com.scweb.projectservice.model.UserAccount;
import com.scweb.projectservice.service.ProjectService;
import com.scweb.projectservice.service.UserAccountService;
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

    private final UserAccountService userAccountService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(@RequestParam(name = "userId") String userId){
        UserAccount userAccount = userAccountService.findByUserId(userId);
        if(userAccount != null){
            log.info(userId + " --------------- " + userAccount);
            List<Project> projectList = projectService.getAllProjects(userAccount);
            return ResponseEntity.ok(projectList);
        }
        return (ResponseEntity<List<Project>>) ResponseEntity.notFound();
    }

    @PostMapping
    public ResponseEntity<List<Integer>> syncProjects(@RequestParam(name = "userEmail") String userEmail){
        return null;
    }


}
