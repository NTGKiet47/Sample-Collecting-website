package com.scweb.projectservice.repository;

import com.scweb.projectservice.dto.StageDto;
import com.scweb.projectservice.model.Project;
import com.scweb.projectservice.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {

    List<StageDto> findByProject(Project project);
}
