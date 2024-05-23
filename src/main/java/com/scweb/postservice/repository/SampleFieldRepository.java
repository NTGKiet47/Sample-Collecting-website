package com.scweb.postservice.repository;

import com.scweb.postservice.model.Sample;
import com.scweb.postservice.model.SampleField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleFieldRepository extends JpaRepository<SampleField, Long> {

    List<SampleField> findAllBySample(Sample sample);
    void deleteAllBySample(Sample sample);

}