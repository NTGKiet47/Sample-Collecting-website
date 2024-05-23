package com.scweb.projectservice.repository;

import com.scweb.projectservice.dto.SampleDto;
import com.scweb.projectservice.model.Sample;
import com.scweb.projectservice.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
    List<SampleDto> findByStage(Stage stage);

}
