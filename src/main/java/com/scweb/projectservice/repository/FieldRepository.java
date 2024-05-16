package com.scweb.projectservice.repository;

import com.scweb.projectservice.dto.SampleFieldDto;
import com.scweb.projectservice.model.Sample;
import com.scweb.projectservice.model.SampleField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<SampleField, Long> {
    List<SampleFieldDto> findBySample(Sample sample);
}
